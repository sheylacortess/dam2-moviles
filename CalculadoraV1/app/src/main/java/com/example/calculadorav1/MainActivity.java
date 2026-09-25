package com.example.calculadorav1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etOperando1;
    private EditText etOperando2;
    private TextView tvResultado;
    private Button btnSumar;
    private Button btnRestar;
    private Button btnMultiplicar;
    private Button btnDividir;

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
        btnSumar=findViewById(R.id.btnSumar);
        btnRestar=findViewById(R.id.btnRestar);
        btnMultiplicar=findViewById(R.id.btnMultiplicar);
        btnDividir=findViewById(R.id.btnDividir);

    }



    public void sumar(View view) {
        operando1 =Double.parseDouble(etOperando1.getText().toString()); //queremos que el operando 1 coja el String del EditText del operando 1 y que ademas lo pase a Double
        operando2 =Double.parseDouble(etOperando2.getText().toString());
        resultado = operando1 + operando2;
        tvResultado.setText(resultado.toString()); // utilizamos un metodo de asignacion
    }

    public void restar(View view) {
        operando1 =Double.parseDouble(etOperando1.getText().toString());
        operando2 =Double.parseDouble(etOperando2.getText().toString());
        resultado = operando1 - operando2;
        tvResultado.setText(resultado.toString());
    }

    public void multiplicar(View view) {
        operando1 =Double.parseDouble(etOperando1.getText().toString());
        operando2 =Double.parseDouble(etOperando2.getText().toString());
        resultado = operando1 * operando2;
        tvResultado.setText(resultado.toString());
    }

    public void dividir(View view) {
        operando1 =Double.parseDouble(etOperando1.getText().toString());
        operando2 =Double.parseDouble(etOperando2.getText().toString());
        resultado = operando1 / operando2;
        tvResultado.setText(resultado.toString());
        if(operando2 == 0) {
            Toast.makeText(getApplicationContext(), "No se puede dividir entre 0" , Toast.LENGTH_LONG).show();
        }
    }
}