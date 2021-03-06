package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.FinanceSumAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.FinanceSumBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.FinanceSumContract;
import com.ipd.jianghuzuchebusiness.presenter.FinanceSumPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：财务统计
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class FinanceSumActivity extends BaseActivity<FinanceSumContract.View, FinanceSumContract.Presenter> implements FinanceSumContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_finance_sum_top)
    TopView tvFinanceSumTop;
    @BindView(R.id.tv_finance_sum)
    TextView tvFinanceSum;
    @BindView(R.id.tv_finance_sum_one)
    TextView tvFinanceSumOne;
    @BindView(R.id.tv_finance_sum_two)
    TextView tvFinanceSumTwo;
    @BindView(R.id.tv_finance_sum_three)
    TextView tvFinanceSumThree;
    @BindView(R.id.rv_finance_sum)
    RecyclerView rvFinanceSum;
    @BindView(R.id.bt_finance_sum)
    Button btFinanceSum;
    @BindView(R.id.srl_finance_sum)
    SwipeRefreshLayout srlFinanceSum;

    private FinanceSumAdapter financeSumAdapter;
    private List<FinanceSumBean.DataBean.UserDetailedBean> financeSumBean;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_finance_sum;
    }

    @Override
    public FinanceSumContract.Presenter createPresenter() {
        return new FinanceSumPresenter(this);
    }

    @Override
    public FinanceSumContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvFinanceSumTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvFinanceSum.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvFinanceSum.setHasFixedSize(true);
        rvFinanceSum.setItemAnimator(new DefaultItemAnimator());

        financeSumBean = new ArrayList<>();
        financeSumAdapter = new FinanceSumAdapter(financeSumBean);
        rvFinanceSum.setAdapter(financeSumAdapter);
    }

    @Override
    public void initListener() {
        srlFinanceSum.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlFinanceSum.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> financeSumMap = new TreeMap<>();
        financeSumMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        financeSumMap.put("page", page + "");
        getPresenter().getFinanceSum(financeSumMap, false, false);
    }

    @OnClick(R.id.bt_finance_sum)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {
            startActivity(new Intent(this, CashWithdrawalActivity.class));
        }
    }

    @Override
    public void resultFinanceSum(FinanceSumBean data) {
        tvFinanceSum.setText(data.getData().getUserData().getCumulativeMoney() + "");
        tvFinanceSumOne.setText(data.getData().getUserData().getAvailableMoney() + "");
        tvFinanceSumTwo.setText(data.getData().getUserData().getDayMoney() + "");
        tvFinanceSumThree.setText(data.getData().getUserData().getMonthMoney() + "");

        if (page == 0) {
            financeSumBean.clear();
            financeSumBean.addAll(data.getData().getUserDetailed());
            financeSumAdapter.setNewData(financeSumBean);
            if (data.getData().getUserDetailed().size() > 0) {
                page += 1;
                financeSumAdapter.setOnLoadMoreListener(this, rvFinanceSum);
            } else {
                financeSumAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getUserDetailed().size() > 0) {
                page += 1;
                financeSumAdapter.addData(data.getData().getUserDetailed());
                financeSumAdapter.loadMoreComplete();
            } else {
                financeSumAdapter.loadMoreEnd();
            }
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }
}
