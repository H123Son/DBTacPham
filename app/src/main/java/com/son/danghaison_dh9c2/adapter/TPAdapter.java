package com.son.danghaison_dh9c2.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.son.danghaison_dh9c2.R;
import com.son.danghaison_dh9c2.entities.TacPham;

import java.util.List;

public class TPAdapter extends BaseAdapter {
    private final Context context;
    private final List<TacPham> tacPhamList;

    public TPAdapter(Context context, List<TacPham> SVList) {
        this.context = context;
        this.tacPhamList = SVList;
    }

    @Override
    public int getCount() {
        return tacPhamList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_listsv, null);
            // ánh xạ
            viewHolder.tvmaTP = convertView.findViewById(R.id.ma_tac_pham);
            viewHolder.tvtenTP = convertView.findViewById(R.id.tv_tentp);
            viewHolder.tvNXB = convertView.findViewById(R.id.tv_nxb);
            viewHolder.tvsoXB = convertView.findViewById(R.id.tv_so_xb);
            viewHolder.tvsluong = convertView.findViewById(R.id.tv_soluong);
            viewHolder.tvdongia = convertView.findViewById(R.id.tv_dongia);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Thiết lập giá trị
        TacPham sv = tacPhamList.get(position);
        viewHolder.tvmaTP.setText("Mã tác phẩm: " + sv.getMaTP());
        viewHolder.tvtenTP.setText("Tên tác phẩm: " + sv.getTenTP());
        viewHolder.tvNXB.setText("NXB : " + sv.getNxb());
        viewHolder.tvsoXB.setText("Số xb: " + sv.getSoxuatban());
        viewHolder.tvsluong.setText("Số lương: " + sv.getSoluong());
        viewHolder.tvdongia.setText("Đơn giá: " + sv.getDongia());

        return convertView;
    }

     class ViewHolder {
        TextView tvmaTP, tvtenTP, tvNXB,tvsoXB, tvsluong, tvdongia;

    }
}
