package com.example.projectkp.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectkp.R;

public class NotaPenjualanActivity extends AppCompatActivity {

    String noInvoice_nota, namaCustomer_nota, noHP_nota, alamat_nota,tglPesan_nota;
    Context ctx;
    EditText etNoInvoice_nota, etNamaCustomer_nota,etNoHP_nota, etAlamat_nota, etTglPesan_nota;
    Button btnNextNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nota_penjualan);

        Intent i = getIntent();
        noInvoice_nota = i.getStringExtra("xNoInvoice_nota");
        namaCustomer_nota = i.getStringExtra("xNamaCustomer_nota");
        noHP_nota= i.getStringExtra("xNoHP_nota");
        alamat_nota = i.getStringExtra("xAlamat_nota");
        tglPesan_nota = i.getStringExtra("xtglPesan_nota");

        etNoInvoice_nota = findViewById(R.id.et_invoice_nota);
        etNamaCustomer_nota =findViewById(R.id.et_namacustomer_nota);
        etNoHP_nota = findViewById(R.id.et_nohp_nota);
        etAlamat_nota = findViewById(R.id.et_alamat_nota);
        etTglPesan_nota = findViewById(R.id.et_tglPesan_nota);

        etNamaCustomer_nota.setText(namaCustomer_nota);
        etNoHP_nota.setText(noHP_nota);
        etAlamat_nota.setText(alamat_nota);
        etTglPesan_nota.setText(tglPesan_nota);

        btnNextNota = findViewById(R.id.btn_next_nota);

        btnNextNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noInvoice_nota =etNoInvoice_nota.getText().toString();
                namaCustomer_nota = etNamaCustomer_nota.getText().toString();
                noHP_nota = etNoHP_nota.getText().toString();
                alamat_nota = etAlamat_nota.getText().toString();
                tglPesan_nota = etTglPesan_nota.getText().toString();

                if(namaCustomer_nota.trim().isEmpty()){
                    etNamaCustomer_nota.setError("Nama Supplier tidak boleh Kosong");
                }
                else if(noHP_supplier.trim().isEmpty()){
                    etNoHP_supplier.setError("No Handphone tidak boleh Kosong");
                }
                else if(alamat_supplier.trim().isEmpty()){
                    etAlamat_supplier.setError("Alamat tidak boleh Kosong");
                }
//                else{
//                    tambahSupplier(namaSupplier,noHP,alamat);
//                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}