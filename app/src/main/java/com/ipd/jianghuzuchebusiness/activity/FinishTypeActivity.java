package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import butterknife.BindView;

/**
 * Description ：取消成功/提现成功
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class FinishTypeActivity extends BaseActivity {

    @BindView(R.id.tv_finish_type_top)
    TopView tvFinishTypeTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.iv_finish_type)
    ImageView ivFinishType;
    @BindView(R.id.tv_finish_type)
    TextView tvFinishType;
    @BindView(R.id.tv_finish_type_tips)
    TextView tvFinishTypeTips;

    private int finish_type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_finish_type;
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
        ImmersionBar.setTitleBar(this, tvFinishTypeTop);

        finish_type = getIntent().getIntExtra("finish_type", 0);
        switch (finish_type) {
            case 0:
                tvTopTitle.setText("取消成功");
                break;
            case 1:
                tvTopTitle.setText("提现成功");
                break;
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        switch (finish_type) {
            case 0:
                ivFinishType.setImageResource(R.drawable.ic_pay_success);
                tvFinishType.setText("取消成功");
                tvFinishTypeTips.setText("用户租金、押金已退至余额");
                break;
            case 1:
                tvTopTitle.setText("提现成功");
                ivFinishType.setImageResource(R.drawable.ic_pay_success);
                tvFinishType.setText("提现成功");
                tvFinishTypeTips.setText("您的提现已成功，钱款会在3～5天内到账");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_OK, new Intent().putExtra("is_refresh", "1"));
    }
}
