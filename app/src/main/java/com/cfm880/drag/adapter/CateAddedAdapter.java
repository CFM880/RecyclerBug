package com.cfm880.drag.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cfm880.drag.R;
import com.cfm880.drag.entity.Menu;
import com.cfm880.drag.helper.ItemTouchHelperAdapter;
import com.cfm880.drag.helper.ItemTouchHelperViewHolder;
import com.orhanobut.logger.Logger;

import java.util.Collections;
import java.util.List;

/**
 * Created by chengfangming on 2017/3/15.
 */

public class CateAddedAdapter extends RecyclerView.Adapter<CateAddedAdapter.CateViewHolder> implements ItemTouchHelperAdapter{

    private Context mContext;
    private List<Menu.CateBean.ItemBean> addedItems;
    private OnOperationClickListener onOperationClickListener;
    private RecyclerView recyclerView;

    public List<Menu.CateBean.ItemBean> getAddedItems() {
        return addedItems;
    }

    public void setAddedItems(List<Menu.CateBean.ItemBean> addedItems) {
        this.addedItems = addedItems;
    }

    public CateAddedAdapter(List<Menu.CateBean.ItemBean> addedItems) {
        this.addedItems = addedItems;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.cate_item, parent, false);
        CateViewHolder cateViewHolder = new CateViewHolder(view);
        return cateViewHolder;
    }

    @Override
    public void onBindViewHolder(final CateViewHolder holder, final int position) {
        Glide.with(mContext).load(
                addedItems.get(position).getImg()).into(holder.cateImageView);
        holder.cateName.setText(addedItems.get(position).getName());
        holder.operationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int childLayoutPosition = recyclerView.getChildLayoutPosition(holder.itemView);
                if (recyclerView.getChildCount() > 1){
                    onOperationClickListener.onOperationClick(childLayoutPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return addedItems.size();
    }
    


    public class CateViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder{
        public ImageView cateImageView;
        public TextView cateName;
        public ImageView operationImageView;

        public CateViewHolder(View itemView) {
            super(itemView);
            cateImageView = (ImageView) itemView.findViewById(R.id.cate_imageview);
            cateName = (TextView) itemView.findViewById(R.id.cate_name);
            operationImageView = (ImageView) itemView.findViewById(R.id.operation_imageview);
        }

        @Override
        public void onItemSelected() {
            itemView.setAlpha(0.7f);
        }

        @Override
        public void onItemClear() {
            itemView.setAlpha(1f);
        }
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap( addedItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        Logger.d("onItemDismiss"+position);

        addedItems.remove(position);
        notifyItemRemoved(position);
    }


}
