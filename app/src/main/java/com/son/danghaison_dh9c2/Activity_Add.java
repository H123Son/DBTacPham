package com.son.danghaison_dh9c2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.son.danghaison_dh9c2.dao.TacPhamDao;
import com.son.danghaison_dh9c2.entities.TacPham;

public class Activity_Add extends AppCompatActivity {
    private EditText edtMa, edtTenTP, edtNXB, edtsõB, edtsluong,edtDonGia;
    private Button btnThem, btnThoat;
    private TacPhamDao svDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhxa();
        svDao = new TacPhamDao(Activity_Add.this);


        // bắt sự kiện cho btnThem
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int masv = 0;
                try {
                    masv = Integer.parseInt(edtMa.getText().toString());

                } catch (NumberFormatException e) {
                    e.getStackTrace();
                }
                String tenTP = edtTenTP.getText().toString();
                String nxb = edtNXB.getText().toString();
                String sxb = edtsõB.getText().toString();
                String soluong = edtsluong.getText().toString();
                String donGia = edtDonGia.getText().toString();
                TacPham sv = new TacPham(masv, tenTP, nxb, sxb, soluong, donGia);
                svDao.ThemTP(sv);
                Toast.makeText(Activity_Add.this, "add success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(Activity_Add.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        edtMa = findViewById(R.id.edt_ma);
        edtTenTP = findViewById(R.id.edt_ten_tp);
        edtNXB = findViewById(R.id.edtLnxb);
        edtsõB = findViewById(R.id.edt_so_xb);
        edtsluong = findViewById(R.id.edt_nhap_sl);
        edtDonGia = findViewById(R.id.edt_don_gia);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);


    }
}
