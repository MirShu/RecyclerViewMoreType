# RecyclerViewMoreType
## 不同类型RecyclerView

![QQ截图20230206175216](https://user-images.githubusercontent.com/13359093/216940474-4f701a00-f062-4b2e-874a-afec28055735.png)




#  很多事都需要不同类型的 RecyclerView   item

新闻和购物类的app 然后加上头部，和中间穿插各种复杂的布局

```
  GridLayoutManager gridLayoutManager;
    private List<String> list;
    private void bindData() {

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 1, LinearLayoutManager.VERTICAL, false);
        recyclerBjbView.setLayoutManager(gridLayoutManager);
        adapter = new VoteInfoAdapter(list);
        recyclerBjbView.setAdapter(adapter);

        setHeader(recyclerBjbView);
        setMiddle(recyclerBjbView);
    }



    //添加头部
    private void setHeader(RecyclerView view) {
        View header = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_head, view, false);
        adapter.setHeaderView(header);

    }


    //在RecycleView 中间添加布局
    private void setMiddle(RecyclerView view) {
        View middle = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_middle, view, false);
        adapter.setMiddleView(middle);
    }


```

关键代码块，就是加入 adapter， setHeader 和setMiddle  如果想加更多的中间布局可以继续加 和setMiddle2、和setMiddle3......
但是加多少记得要获取 ViewHolder   真实的位置，要不然就会出现数组越界了

# 这个是我加了插入两个布局在 RecyclerView 所以是减掉两个 position  才是真实的数据集合
```
  /**
     * 获取条目的真实位置
     */
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return position - 2;
    }

```

自己还可以扩展更多的类型布局插入在 RecyclerView里面






