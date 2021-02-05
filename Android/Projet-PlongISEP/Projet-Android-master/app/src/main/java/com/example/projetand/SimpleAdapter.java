package com.example.projetand;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Locale;

public class SimpleAdapter extends RecyclerView.Adapter {
    private List<SimpleViewModel> values;


    public SimpleAdapter(List<SimpleViewModel> myDataset) {
        values = myDataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new SimpleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((SimpleViewHolder) holder).bindData(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_simple_itemview;
    }
}