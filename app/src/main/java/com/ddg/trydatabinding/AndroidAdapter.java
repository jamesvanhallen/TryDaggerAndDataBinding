package com.ddg.trydatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ddg.trydatabinding.databinding.ItemDeviceBinding;
import com.ddg.trydatabinding.model.AndroidDTO;

import java.util.ArrayList;
import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidItemViewHolder> {

    private List<AndroidDTO> mAndroids;

    public AndroidAdapter(){
        mAndroids = new ArrayList<>();
    }

    @Override
    public AndroidItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemDeviceBinding binding = ItemDeviceBinding.inflate(inflater, parent, false);
        return new AndroidItemViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(AndroidItemViewHolder holder, int position) {
        AndroidDTO android = mAndroids.get(position);
        holder.binding.setDevice(android);
    }

    @Override
    public int getItemCount() {
        return mAndroids.size();
    }

    public void setAndroids(List<AndroidDTO> list){
        this.mAndroids = list;
        notifyItemInserted(0);
    }

    public static class AndroidItemViewHolder extends RecyclerView.ViewHolder{
        private ItemDeviceBinding binding;

        public AndroidItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
