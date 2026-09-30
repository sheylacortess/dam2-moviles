package com.example.a04_calculadoraprogramatica;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { //en esta version implementamos el metodo de escucha para cuando se pulsa un boton

    private EditText etOperando1;
    private EditText etOperando2;
    private TextView tvResultado;
    private RadioButton rbSumar;
    private RadioButton rbRestar;
    private RadioButton rbMultiplicar;
    private RadioButton rbDividir;

    private Double operando1, operando2, resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etOperando1=findViewById(R.id.etOperando1);
        etOperando2=findViewById(R.id.etOperando2);
        tvResultado=findViewById(R.id.tvResultado);
        rbSumar=findViewById(R.id.rbSumar);
        rbRestar=findViewById(R.id.rbRestar);
        rbMultiplicar=findViewById(R.id.rbMultiplicar);
        rbDividir=findViewById(R.id.rbDividir);

        // en esta version queremos que la aplicacion se de cuenta que interactuamos con lo elementos clickables -- OnClickListener
        // vamos a poner los botones preparados para escuchar el evento de clicado (cuando se le haga click)
        rbSumar.setOnClickListener(this);
        rbRestar.setOnClickListener(this);
        rbMultiplicar.setOnClickListener(this);
        rbDividir.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) { // dentro de las vistas uqe tengo en mi aplicacion a mi me interesa que esos botones (que son un tipo de vistas) hagan lo que tengan que hacer, con un solo metodo voy a poder elegir lo que hace cada boon al elegirse, este metodo diferencia internamente de que bono se trata para que se ejecute la operacion correcta
        try {
            operando1 = Double.parseDouble(etOperando1.getText().toString());
            operando2 = Double.parseDouble(etOperando2.getText().toString());

            if (v.getId() == R.id.rbSumar) {
                resultado = operando1 + operando2;
            }
            if (v.getId() == R.id.rbRestar) {
                resultado = operando1 - operando2;
            }
            if (v.getId() == R.id.rbMultiplicar) {
                resultado = operando1 * operando2;
            }
            if (v.getId() == R.id.rbDividir) {
                if (operando2 == 0) {
                    Toast.makeText(getApplicationContext(), "No se puede dividir entre 0", Toast.LENGTH_LONG).show();
                } else {
                    resultado = operando1 / operando2;
                }
            }
            tvResultado.setText(resultado.toString());

        } catch (NumberFormatException e) {
            //Toast.makeText(getApplicationContext(), "No puedes dejar los operandos vacios", Toast.LENGTH_LONG).show();
            Log.e("ERROR", e.toString()); // con esto conseguiriamos que la app no se cerra con el error
        }

    }
}