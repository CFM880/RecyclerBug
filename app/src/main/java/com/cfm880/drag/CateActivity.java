package com.cfm880.drag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.cfm880.drag.adapter.CateAddedAdapter;
import com.cfm880.drag.adapter.CateUnselectedAdapter;
import com.cfm880.drag.constant.Data;
import com.cfm880.drag.entity.Menu;
import com.cfm880.drag.helper.OnStartDragListener;
import com.cfm880.drag.helper.SimpleItemTouchHelperCallback;
import com.cfm880.drag.adapter.OnOperationClickListener;
import com.cfm880.drag.view.TopBar;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class CateActivity extends AppCompatActivity  implements OnStartDragListener{
    private Menu menu;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }
    List<Menu.CateBean.ItemBean> addedItems = new ArrayList<Menu.CateBean.ItemBean>();
    List<Menu.CateBean.ItemBean> unselectedItems = new ArrayList<Menu.CateBean.ItemBean>();
    private void initData() {
        Gson gson = new Gson();
        String extraData = Data.data;
        menu = gson.fromJson(extraData, Menu.class);
//        menu = gson.fromJson(Data.data, Menu.class);
        List<Menu.CateBean.ItemBean> items = menu.getCate().getItem();
        for (Menu.CateBean.ItemBean item : items) {
            if (item.getDefaultX() == 1){
                addedItems.add(item);
            } else {
                unselectedItems.add(item);
            }
        }
    }

    private void initView() {


        final RecyclerView mAddedRecyclerView = (RecyclerView) findViewById(R.id.added_recyclerview);
        mAddedRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));
//        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
//        mAddedRecyclerView.setLayoutManager(layoutManager);
        RecyclerView mUnselectedRecyclerView = (RecyclerView) findViewById(R.id.unselected_recyclerview);
        mUnselectedRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, OrientationHelper.VERTICAL));


        final CateAddedAdapter cateAddedAdapter = new CateAddedAdapter(addedItems);
        final CateUnselectedAdapter cateUnselectedAdapter = new CateUnselectedAdapter(unselectedItems);
        cateAddedAdapter.setOnOperationClickListener(new OnOperationClickListener() {
            @Override
            public void onOperationClick(int position) {
                // 获取删除现
                List<Menu.CateBean.ItemBean> addedItems = cateAddedAdapter.getAddedItems();
                Menu.CateBean.ItemBean itemBean = addedItems.get(position);
                addedItems.remove(position);
                cateAddedAdapter.setAddedItems(addedItems);
                cateAddedAdapter.notifyItemRemoved(position);

                // 添加数据
                List<Menu.CateBean.ItemBean> unselectedItems = cateUnselectedAdapter.getUnselectedItems();
                itemBean.setDefaultX(0);
                int insertPostion = 0;
                unselectedItems = cateUnselectedAdapter.getUnselectedItems();
                if (unselectedItems.size() > 0){
                    if (itemBean.getWeights() < unselectedItems.get(0).getWeights()){
                        insertPostion = 0;
                        unselectedItems.add(0, itemBean);
                    } else if (itemBean.getWeights() > unselectedItems.get(unselectedItems.size() - 1).getWeights()){
                        unselectedItems.add(unselectedItems.size() - 1, itemBean);
                        insertPostion = unselectedItems.size() - 1;
                    } else {
                        for (int i = 1; i < unselectedItems.size() - 1; i++) {
                            if (itemBean.getWeights() > unselectedItems.get(i).getWeights() &&
                                    itemBean.getWeights() < unselectedItems.get(i + 1).getWeights()){
                                unselectedItems.add(i, itemBean);
                                insertPostion = i;
                                break;
                            }
                        }
                    }
                } else {
                    unselectedItems.add(0, itemBean);
                }
                cateUnselectedAdapter.setUnselectedItems(unselectedItems);
                cateUnselectedAdapter.notifyItemInserted(insertPostion);
                addedItems = null;
                unselectedItems = null;
                itemBean = null;

            }
        });
        cateUnselectedAdapter.setOnOperationClickListener(new OnOperationClickListener() {
            @Override
            public void onOperationClick(int position) {
                // 获取删除现
                List<Menu.CateBean.ItemBean> unselectedItems = cateUnselectedAdapter.getUnselectedItems();
                Menu.CateBean.ItemBean itemBean = unselectedItems.get(position);
                unselectedItems.remove(position);
                cateUnselectedAdapter.setUnselectedItems(unselectedItems);
                cateUnselectedAdapter.notifyItemRemoved(position);

                // 添加数据
                List<Menu.CateBean.ItemBean> addedItems = cateAddedAdapter.getAddedItems();
                itemBean.setDefaultX(1);
                addedItems.add(itemBean);
                cateAddedAdapter.setAddedItems(addedItems);
                cateAddedAdapter.notifyItemInserted(addedItems.size());
                unselectedItems = null;
                addedItems = null;
                itemBean = null;
            }
        });

        mAddedRecyclerView.setAdapter(cateAddedAdapter);
        mUnselectedRecyclerView.setAdapter(cateUnselectedAdapter);
        mItemTouchHelper = new ItemTouchHelper(new SimpleItemTouchHelperCallback(cateAddedAdapter));
        mItemTouchHelper.attachToRecyclerView(mAddedRecyclerView);
        // 获取数据
        findViewById(R.id.get_reorder_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                List<Menu.CateBean.ItemBean> addedItems = cateAddedAdapter.getAddedItems();
                addedItems.addAll(cateUnselectedAdapter.getUnselectedItems());
                Menu.CateBean cate = menu.getCate();
                cate.setItem(addedItems);
                menu.setCate(cate);
                cate = null;
                Logger.json(gson.toJson(menu));
            }
        });

        TopBar topBar = (TopBar) findViewById(R.id.MyTopbar);
        topBar.setLeftButtonVisibility(false);
        topBar.setListener(new TopBar.TopBarClickListener() {
            @Override
            public void leftClick() {

            }

            @Override
            public void rightClick() {
                Gson gson = new Gson();
                List<Menu.CateBean.ItemBean> addedItems = cateAddedAdapter.getAddedItems();
                addedItems.addAll(cateUnselectedAdapter.getUnselectedItems());
                Menu.CateBean cate = menu.getCate();
                cate.setItem(addedItems);
                menu.setCate(cate);
                cate = null;
                Logger.json(gson.toJson(menu));
                gson = null;
                finish();
            }
        });
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
