package com.example.a05_calculadoraprogramatica;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener { // este es menos utilizado pero es mas especifico para los radioBUttons
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

        //ahora con set on CheckedChangeListener
        // vamos a poner los botones preparados para escuchar el evento de clicado (cuando se le haga click)
        rbSumar.setOnCheckedChangeListener(this);
        rbRestar.setOnCheckedChangeListener(this);
        rbMultiplicar.setOnCheckedChangeListener(this);
        rbDividir.setOnCheckedChangeListener(this);

    }


    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) { // el objeto que estamos pasando como parametro es un boton compuesto (CompundButton) llamado buttonView
        try {
            operando1 = Double.parseDouble(etOperando1.getText().toString());
            operando2 = Double.parseDouble(etOperando2.getText().toString());

            if (rbSumar.isChecked()) { // pongo que si esta selecionado que haga la operacion
                resultado = operando1 + operando2;
            }
            if (rbRestar.isChecked()) {
                resultado = operando1 - operando2;
            }
            if (rbMultiplicar.isChecked()) {
                resultado = operando1 * operando2;
            }
            if (rbDividir.isChecked()) {
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