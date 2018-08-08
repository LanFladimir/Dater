package com.dev_lan.dater.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.dev_lan.dater.R;
import com.dev_lan.dater.bean.Dater;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaterAdapter extends RecyclerView.Adapter<DaterAdapter.DaterHolder> {
    List<Dater> mDaterList = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);


    public DaterAdapter(List<Dater> daterList) {
        mDaterList = daterList;
    }

    @NonNull
    @Override
    public DaterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaterHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_dater, null));
    }

    @Override
    public void onBindViewHolder(@NonNull DaterHolder holder, int position) {
        Dater item = mDaterList.get(position);
        holder.title.setText(item.getDateTitle());
        holder.date.setText(dateFormat.format(item.getDeadLine()));
    }

    @Override
    public int getItemCount() {
        return mDaterList.size();
    }

    class DaterHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;

        public DaterHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_dater_title);
            date = itemView.findViewById(R.id.item_dater_date);
        }
    }
}
