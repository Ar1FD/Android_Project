package com.example.kampusku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class updatedata extends AppCompatActivity {
    DataHelper dbHelper;
    EditText text1, text2, text3, text4, text5;
    Button ton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedata);

        dbHelper = new DataHelper(this);
        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        ton1 = findViewById(R.id.button1);

        // Get the "nama" extra passed from the previous activity
        String nama = getIntent().getStringExtra("nama");

        // Fetch data from the database and populate EditText fields
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = ?", new String[]{nama});
        if (cursor.moveToFirst()) {
            text1.setText(cursor.getString(0));
            text2.setText(cursor.getString(1));
            text3.setText(cursor.getString(2));
            text4.setText(cursor.getString(3));
            text5.setText(cursor.getString(4));
        }
        cursor.close();

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Get values from EditText fields
                String no = text1.getText().toString();
                String nama = text2.getText().toString();
                String tgl = text3.getText().toString();
                String jk = text4.getText().toString();
                String alamat = text5.getText().toString();

                // Check if any field is empty
                if (no.isEmpty() || nama.isEmpty() || tgl.isEmpty() || jk.isEmpty() || alamat.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kolom tidak boleh kosong...", Toast.LENGTH_SHORT).show();
                } else {
                    // Update the database entry
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("UPDATE biodata SET nama = ?, tgl = ?, jk = ?, alamat = ? WHERE no = ?",
                            new String[]{nama, tgl, jk, alamat, no});
                    Toast.makeText(getApplicationContext(), "Perubahan Tersimpan...", Toast.LENGTH_LONG).show();
                    finish(); // Close the activity
                    datamahasiswa.da.RefreshList(); // Refresh the list in the previous activity
                }
            }
        });
    }
}
