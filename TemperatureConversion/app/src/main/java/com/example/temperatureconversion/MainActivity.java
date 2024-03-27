package com.example.temperatureconversion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText celcius, kelvin, farenheit, reamur;
    Button btn_konversi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celcius = (EditText) findViewById(R.id.edt_celcius);
        kelvin = (EditText) findViewById(R.id.edt_kelvin);
        farenheit = (EditText) findViewById(R.id.edt_farenheit);
        reamur = (EditText) findViewById(R.id.edt_reamur);
        btn_konversi = (Button) findViewById(R.id.btn_konversi);
    }
    public void konversisuhu(View view) {
        try {
            int nilcelcius =
                    Integer.parseInt(celcius.getText().toString());
            double hasilkelvin = nilcelcius + 273.15;
            double hasilfarenheit = nilcelcius * 1.8 + 32;
            double hasilreamur = nilcelcius * 1.8;
            kelvin.setText(String.valueOf(hasilkelvin));
            farenheit.setText(String.valueOf(hasilfarenheit));
            reamur.setText(String.valueOf(hasilreamur));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
