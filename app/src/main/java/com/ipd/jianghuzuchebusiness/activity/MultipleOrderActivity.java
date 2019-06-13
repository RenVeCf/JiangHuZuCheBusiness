package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ViewPagerAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.common.view.NavitationLayout;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.fragment.MultipleOrderFragment;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description ：历史/维保订单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class MultipleOrderActivity extends BaseActivity {

    @BindView(R.id.tv_multiple_order_top)
    TopView tvMultipleOrderTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.nl_multiple_order)
    NavitationLayout nlMultipleOrder;
    @BindView(R.id.vp_multiple_order)
    ViewPager vpMultipleOrder;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.rl_order_search)
    RelativeLayout rlOrderSearch;
    @BindView(R.id.view_line)
    View viewLine;

    private String[] titles;
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragments;
    private int multipleType;
    private MultipleOrderFragment fm = null;
    private int positions = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_multiple_order;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvMultipleOrderTop);

        multipleType = getIntent().getIntExtra("multiple_type", 0);
        switch (multipleType) {
            case 0:
                tvTopTitle.setText("历史订单");
                titles = new String[]{"全部", "已取车", "未取车", "已取消"};
                viewLine.setVisibility(View.GONE);
                break;
            case 1:
                tvTopTitle.setText("历史订单");
                titles = new String[]{"全部", "已退车", "未退车", "已取消"};
                viewLine.setVisibility(View.GONE);
                break;
            case 2:
                tvTopTitle.setText("维保订单");
                titles = new String[]{"全部", "进行中", "已完成", "已取消"};
                rlOrderSearch.setVisibility(View.GONE);
                break;
        }
        //向集合添加Fragment
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            Bundle args = new Bundle();
            args.putInt("multiple_fm_type", multipleType);
            args.putInt("status_position", i);
            fm = new MultipleOrderFragment();
            fm.setArguments(args);
            fragments.add(fm);
        }
        viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager(), fragments);
        vpMultipleOrder.setAdapter(viewPagerAdapter);
        vpMultipleOrder.setOffscreenPageLimit(titles.length);

        //设置导航条
        nlMultipleOrder.setViewPager(this, titles, vpMultipleOrder, R.color.tx_bottom_navigation, R.color.tx_bottom_navigation_select, 16, 16, 0, 45, true);
        nlMultipleOrder.setBgLine(this, 0, R.color.whitesmoke);
        nlMultipleOrder.setNavLine(this, 3, R.color.tx_bottom_navigation_select, 0);
    }

    @Override
    public void initListener() {
        nlMultipleOrder.setOnNaPageChangeListener(new NavitationLayout.OnNaPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                positions = position;
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.iv_search)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {
            Intent intent = new Intent("android.ipd.action");
            intent.putExtra("positions", positions);
            intent.putExtra("content", etSearch.getText().toString().trim());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        }
    }
}
