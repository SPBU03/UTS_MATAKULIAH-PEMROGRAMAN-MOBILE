package com.f52124091.shendykalambe_f52124091_aplikasi_uts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PigAdapter extends BaseAdapter {
    private Context context;
    private List<PigBreed> pigList;
    private List<PigBreed> pigListFiltered;
    private LayoutInflater inflater;

    public PigAdapter(Context context, List<PigBreed> pigList) {
        this.context = context;
        this.pigList = pigList;
        this.pigListFiltered = new ArrayList<>(pigList);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return pigListFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return pigListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imgPig;
        TextView tvName;
        TextView tvOrigin;
        TextView tvCharacteristics;
        TextView tvType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_pig, parent, false);
            holder = new ViewHolder();
            holder.imgPig = convertView.findViewById(R.id.img_pig);
            holder.tvName = convertView.findViewById(R.id.tv_pig_name);
            holder.tvOrigin = convertView.findViewById(R.id.tv_pig_origin);
            holder.tvCharacteristics = convertView.findViewById(R.id.tv_pig_characteristics);
            holder.tvType = convertView.findViewById(R.id.tv_pig_type);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        PigBreed pig = pigListFiltered.get(position);
        holder.tvName.setText(pig.getName());
        holder.tvOrigin.setText("Asal: " + pig.getOrigin());
        holder.tvCharacteristics.setText("Ciri-ciri: " + pig.getCharacteristics());
        holder.tvType.setText("Tipe: " + pig.getType());
        holder.imgPig.setImageResource(pig.getImageResId());

        return convertView;
    }

    public void filter(CharSequence query) {
        pigListFiltered.clear();
        if (query == null || query.length() == 0) {
            pigListFiltered.addAll(pigList);
        } else {
            String filterPattern = query.toString().toLowerCase().trim();
            for (PigBreed pig : pigList) {
                if (pig.getName().toLowerCase().contains(filterPattern) ||
                    pig.getOrigin().toLowerCase().contains(filterPattern) ||
                    pig.getType().toLowerCase().contains(filterPattern)) {
                    pigListFiltered.add(pig);
                }
            }
        }
        notifyDataSetChanged();
    }
}
