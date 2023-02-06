package com.example.recyclerviewmoretype;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by SeanLim on 2021-3-26.
 * Company by Shanghai observer information technology Co., Ltd.
 * E-mail linlin.1016@qq.com
 */
public class VoteInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW = 0;
    private static final int NORMAL_VIEW = 1;
    private static final int TYPE_1 = 4;
    private static final int TYPE_2 = 5;

    private View mHeaderView;
    private View mMiddleView;

    VoteInfoViewHolder baseBindViewHolder = new VoteInfoViewHolder();
    List<String> mList;

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
    }

    public void setMiddleView(View middleView) {
        mMiddleView = middleView;
    }


    public VoteInfoAdapter(List<String> list) {
        this.mList = list;
    }


    @Override
    public int getItemCount() {
        if (mList != null && mList.size() != 0) {
            try {
                return mList.size() + 2;
            } catch (Exception e) {

            }
        }


        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER_VIEW;
        }
        if (position == 1) {
            return NORMAL_VIEW;
        } else {
            if (mList.get(getPosition(position)).equals("0")) {
                return TYPE_1;
            } else {
                return TYPE_2;
            }

        }
    }

    public int getPosition(int i) {
        return i - 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mHeaderView != null && viewType == HEADER_VIEW) {
            return new VoteInfoViewHolder.mViewHolder(mHeaderView);
        }
        if (mMiddleView != null && viewType == NORMAL_VIEW) {
            return new VoteInfoViewHolder.mViewHolder((mMiddleView));
        }


        if (viewType == TYPE_1) {
            return new VoteInfoViewHolder.mViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vote_single, null, false)));
        } else {
            return new VoteInfoViewHolder.mViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vote_multi, null, false)));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == HEADER_VIEW) {
            if (holder instanceof VoteInfoViewHolder.mViewHolder) {
                baseBindViewHolder.onBindViewHeader(mList);
            }
            return;
        }
        if (getItemViewType(position) == NORMAL_VIEW) {
            if (holder instanceof VoteInfoViewHolder.mViewHolder) {
                baseBindViewHolder.onBindViewMiddle(mList);
            }
            return;
        }

        if (getItemViewType(position) == TYPE_1) {
            if (holder instanceof VoteInfoViewHolder.mViewHolder) {
                baseBindViewHolder.onBindViewTypeOne(holder, mList);
            }
            return;
        }
        if (getItemViewType(position) == TYPE_2) {
            if (holder instanceof VoteInfoViewHolder.mViewHolder) {
                baseBindViewHolder.onBindViewTypeTwo(holder, mList);
            }
            return;
        }


    }


}
