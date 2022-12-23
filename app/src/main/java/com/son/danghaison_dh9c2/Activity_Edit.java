package com.son.danghaison_dh9c2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.son.danghaison_dh9c2.dao.TacPhamDao;
import com.son.danghaison_dh9c2.entities.TacPham;

public class Activity_Edit extends AppCompatActivity {
    private EditText edtMa, edtTenTP, edtNXB, edtsoXB, edtsluong;
    private EditText donGia;
    private Button btnSave, btnExit;
    private TacPhamDao svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        anhxa();
        svDao=new TacPhamDao(Activity_Edit.this);
        Intent intent=getIntent();
        final TacPham sv=(TacPham) intent.getSerializableExtra("DuLieu");
        // Lấy DL
        edtTenTP.setText(sv.getTenTP());
        edtNXB.setText(sv.getNxb());
        edtsoXB.setText(sv.getSoxuatban());
        edtsluong.setText(sv.getSoluong());

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setTenTP(edtTenTP.getText().toString());
                sv.setNxb(edtNXB.getText().toString());
                sv.setSoxuatban(edtsoXB.getText().toString());
                sv.setSoluong(edtsluong.getText().toString());
                svDao.Suatp(sv);
            }
        });
    }

    private void anhxa() {
        edtMa=findViewById(R.id.edt_ma);
        edtTenTP=findViewById(R.id.edt_ten_tp);
        edtNXB=findViewById(R.id.edtLnxb);
        edtsoXB=findViewById(R.id.edt_so_xb);
        edtsluong=findViewById(R.id.edt_nhap_sl);
        btnSave=findViewById(R.id.btnSave);
        btnExit=findViewById(R.id.btnExit);
    }
}
