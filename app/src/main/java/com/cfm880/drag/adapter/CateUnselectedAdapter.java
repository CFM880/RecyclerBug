package com.cfm880.drag.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cfm880.drag.R;
import com.cfm880.drag.entity.Menu;

import java.util.List;

/**
 * Created by chengfangming on 2017/3/15.
 */

public class CateUnselectedAdapter extends RecyclerView.Adapter<CateUnselectedAdapter.CateViewHolder>{

    private Context mContext;
    private List<Menu.CateBean.ItemBean> unselectedItems;
    private OnOperationClickListener onOperationClickListener;
    private RecyclerView recyclerView;

    public CateUnselectedAdapter(List<Menu.CateBean.ItemBean> unselectedItems) {
        this.unselectedItems = unselectedItems;
    }

    public List<Menu.CateBean.ItemBean> getUnselectedItems() {
        return unselectedItems;
    }

    public void setUnselectedItems(List<Menu.CateBean.ItemBean> unselectedItems) {
        this.unselectedItems = unselectedItems;
    }

    public OnOperationClickListener getOnOperationClickListener() {
        return onOperationClickListener;
    }

    public void setOnOperationClickListener(OnOperationClickListener onOperationClickListener) {
        this.onOperationClickListener = onOperationClickListener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public CateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.cate_item_add, parent, false);
        CateViewHolder cateViewHolder = new CateViewHolder(view);
        return cateViewHolder;
    }

    @Override
    public void onBindViewHolder(final CateViewHolder holder, final int position) {
        Glide.with(mContext).load(
                unselectedItems.get(position).getImg()).into(holder.cateImageView);
        holder.cateName.setText(unselectedItems.get(position).getName());
        holder.operationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int childLayoutPosition = recyclerView.getChildLayoutPosition(holder.itemView);
                onOperationClickListener.onOperationClick(childLayoutPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return unselectedItems.size();
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public class CateViewHolder extends RecyclerView.ViewHolder{
        public ImageView cateImageView;
        public TextView cateName;
        public ImageView operationImageView;

        public CateViewHolder(View itemView) {
            super(itemView);
            cateImageView = (ImageView) itemView.findViewById(R.id.cate_imageview);
            cateName = (TextView) itemView.findViewById(R.id.cate_name);
            operationImageView = (ImageView) itemView.findViewById(R.id.operation_imageview);
        }
    }
}
