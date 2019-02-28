package com.example.vivek.videohls;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by parulchugh on 2/26/19.
 */

public class adapter extends RecyclerView.Adapter<adapter.programmingViewHolder> {


    private String[] data;
    private OnUrlistener mOnUrlistener;
    public adapter(String []data, OnUrlistener onUrlistener)
    {
        this.data=data;
        this.mOnUrlistener=onUrlistener;
    }

    @Override
    public programmingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new programmingViewHolder(view,mOnUrlistener);
    }

    @Override
    public void onBindViewHolder(programmingViewHolder holder, int position) {
        String title=data[position];
        holder.textTitle.setText(title);



    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class programmingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgIcon;
        TextView textTitle;
        OnUrlistener onUrlistener;

        public programmingViewHolder(View itemView, OnUrlistener onUrlistener) {
            super(itemView);
            imgIcon = (ImageView)itemView.findViewById(R.id.imgIcon);
            textTitle=(TextView)itemView.findViewById(R.id.textTitle);
            this.onUrlistener=onUrlistener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onUrlistener.OnUrlClick(getAdapterPosition());

        }
    }
    public interface OnUrlistener{
        void OnUrlClick(int position);
    }
}
