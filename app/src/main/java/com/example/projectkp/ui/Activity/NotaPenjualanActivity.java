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

        etNoInvoice_nota = findViewById(R.id.et_invoice_nota);
        etNamaCustomer_nota =findViewById(R.id.et_namacustomer_nota);
        etNoHP_nota = findViewById(R.id.et_nohp_nota);
        etAlamat_nota = findViewById(R.id.et_alamat_nota);
        etTglPesan_nota = findViewById(R.id.et_tglPesan_nota);

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
                else if(namaCustomer_nota.trim().isEmpty()){
                    etNamaCustomer_nota.setError("No Handphone tidak boleh Kosong");
                }
                else if(noHP_nota.trim().isEmpty()){
                    etNoHP_nota.setError("noHP tidak boleh Kosong");
                } else if (alamat_nota.trim().isEmpty()) {
                    etAlamat_nota.setError("Alamat tidak boleh kosong");
                } else if (tglPesan_nota.trim().isEmpty()) {
                    etTglPesan_nota.setError("Tanggal pemesanan tidak boleh kosong");
                }
//                else{
//                    tambahNota();
//                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
//     private void tambahNota(){
//        RequestData ARD = RetroServer.konekRetrofit().create(RequestData.class);
//    Call<ModelResponse> proses = ARD.ardCreate(namaSupplier,noHP_supplier,alamat_supplier);
//
//        proses.enqueue(new Callback<ModelResponse>() {
//            @Override
//            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
//                String kode = response.body().getKode();
//                String pesan = response.body().getPesan();
//                Toast.makeText(SupplierActivity.this,"Kode: " + kode + " Pesan: " + pesan, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ModelResponse> call, Throwable t) {
//                Toast.makeText(SupplierActivity.this, "Gagal Menghubungi Server" , Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}