package com.example.recyclerviewmoretype;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by SeanLim on 2021-3-26.
 * Company by Shanghai observer information technology Co., Ltd.
 * E-mail linlin.1016@qq.com
 */
public class VoteInfoViewHolder {
    private final List<String> banner_image = new ArrayList<>();
    private final ArrayList<String> banner_title = new ArrayList<>();

    public void onBindViewHeader( List<String> mList) {
    }


    public void onBindViewMiddle( List<String> mList) {

    }


    public void onBindViewTypeOne(RecyclerView.ViewHolder holder, List<String> mList) {
        ((mViewHolder) holder).tvTitle.setText("类型111111111111111111");

    }

    public void onBindViewTypeTwo(RecyclerView.ViewHolder holder, List<String> mList) {
        ((mViewHolder) holder).tvTitle.setText("类型2222222222222222");
    }



    /**
     * 获取条目的真实位置
     */
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return position - 2;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;


        public mViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_title);

        }

    }


}
