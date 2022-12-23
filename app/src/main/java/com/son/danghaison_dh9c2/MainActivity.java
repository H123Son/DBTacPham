package com.son.danghaison_dh9c2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.son.danghaison_dh9c2.adapter.TPAdapter;
import com.son.danghaison_dh9c2.dao.TacPhamDao;
import com.son.danghaison_dh9c2.entities.DBHelper;
import com.son.danghaison_dh9c2.entities.TacPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtSearch;
    private Button btnSeach;
    private ListView lvTP;

    private List<TacPham> TPList;
    private TPAdapter adapter;
    private DBHelper db;
    private TacPhamDao tacPhamDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edtSearch=findViewById(R.id.edtSearch);
        btnSeach=findViewById(R.id.btnSearch);
        lvTP =findViewById(R.id.lvsv);

        // Đổ DL
        TPList =new ArrayList<>();
        tacPhamDao =new TacPhamDao(MainActivity.this);
        TPList = tacPhamDao.ThongTintp();
        adapter=new TPAdapter(this, TPList);
        lvTP.setAdapter(adapter);
        onResume();
        registerForContextMenu(lvTP);
        btnSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TPList = tacPhamDao.TimKiemtp(edtSearch.getText().toString());
                adapter=new TPAdapter(getApplicationContext(), TPList);
                lvTP.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuThem:{
                Intent intent=new Intent(MainActivity.this, Activity_Add.class);
                startActivity(intent);
                break;

            }
            case R.id.mnuThoat:{
                finish();
            }
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri=info.position;
        TacPham sv= TPList.get(vitri);
        switch (item.getItemId()){
            case R.id.mnuSua:{
                Intent intent=new Intent(MainActivity.this, Activity_Edit.class);
                intent.putExtra("DuLieu", sv);
                startActivity(intent);
                break;
            }
            case R.id.mnuXoa:{
                tacPhamDao.Xoatp(sv.getMaTP());
                adapter.notifyDataSetChanged();
                onResume();
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TPList.clear();
        TPList.addAll(tacPhamDao.ThongTintp());
        adapter.notifyDataSetChanged();
    }
}