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

public class SupplierActivity extends AppCompatActivity {

    String namaSupplier, noHP_supplier, alamat_supplier;
    Context ctx;
    EditText etNamaSupplier,etNoHP_supplier, etAlamat_supplier;
    Button btnTambahSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier);

        Intent i = getIntent();
        namaSupplier = i.getStringExtra("xNama");
        noHP_supplier = i.getStringExtra("xNoHP");
        alamat_supplier = i.getStringExtra("xAlamat");

        etNamaSupplier =findViewById(R.id.et_nama_supplier_baru);
        etNoHP_supplier = findViewById(R.id.et_nohp_supplier_baru);
        etAlamat_supplier = findViewById(R.id.et_alamat_supplier_baru);

        etNamaSupplier.setText(namaSupplier);
        etNoHP_supplier.setText(noHP_supplier);
        etAlamat_supplier.setText(alamat_supplier);

        btnTambahSupplier = findViewById(R.id.btn_tambah_supplier_baru);

        btnTambahSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaSupplier = etNamaSupplier.getText().toString();
                noHP_supplier = etNoHP_supplier.getText().toString();
                alamat_supplier = etAlamat_supplier.getText().toString();

                if(namaSupplier.trim().isEmpty()){
                    etNamaSupplier.setError("Nama Supplier tidak boleh Kosong");
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

//    private void tambahSupplier(
//            String nama_supplier, String noHP, String alamat_supplier){
//        RequestData ARD = RetroServer.konekRetrofit().create(RequestData.class);
//        Call<ModelResponse> proses = ARD.ardUpdate(id_kost,nama_kost,foto_kost,tipe_kost,daerah_kost,alamat_kost,status_kost,harga_kost,deskripsi_kost);
//
//        proses.enqueue(new Callback<ModelResponse>() {
//            @Override
//            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
//                String kode = response.body().getKode();
//                String pesan = response.body().getPesan();
//                Toast.makeText(UbahActivity.this,"Kode: " + kode + " Pesan: " + pesan, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ModelResponse> call, Throwable t) {
//                Toast.makeText(UbahActivity.this, "Gagal Menghubungi Server" , Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}