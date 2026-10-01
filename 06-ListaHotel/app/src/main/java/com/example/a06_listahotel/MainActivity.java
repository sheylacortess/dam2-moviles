package com.example.a06_listahotel;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox cbDesayuno, cbComida, cbCena;
    private TextView tvPrecio;
    private double precio = 0.0;

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

        cbDesayuno=findViewById(R.id.cbDesayuno);
        cbComida=findViewById(R.id.cbComida);
        cbCena=findViewById(R.id.cbCena);
        tvPrecio=findViewById(R.id.tvPrecio);

        cbDesayuno.setOnCheckedChangeListener(this);
        cbComida.setOnCheckedChangeListener(this);
        cbCena.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {

        try {
            if (buttonView.getId() == R.id.cbDesayuno){
                if (cbDesayuno.isChecked()){
                    precio += 10;
                    tvPrecio.setText(precio.toString());
                }else {
                    precio -= 10;
                }
            }
            if (buttonView.getId() == R.id.cbComida){
                if (cbComida.isChecked()){
                    precio += 25;
                }else {
                    precio -= 25;
                }
            }
            if (buttonView.getId() == R.id.cbCena){
                if (cbCena.isChecked()){
                    precio += 30;
                }else {
                    precio -= 30;
                }
            }
            tvPrecio.setText(precio+"");

        }catch (NumberFormatException e){
            Log.e("ERROR", e.toString());
        }
    }
}