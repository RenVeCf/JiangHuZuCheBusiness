package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class InputActivity extends BaseActivity {

    @BindView(R.id.tv_input_top)
    TopView tvInputTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.et_name_name)
    EditText etNameName;
    @BindView(R.id.bt_name_confirm)
    Button btNameConfirm;

    private int type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_input;
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
        ImmersionBar.setTitleBar(this, tvInputTop);

        type = getIntent().getIntExtra("type", 0);

        switch (type) {
            case 0:
                tvTopTitle.setText("商店名称");
                break;
            case 1:
                tvTopTitle.setText("商店地址");
                break;
            case 2:
                tvTopTitle.setText("联系电话");
                break;
        }
        etNameName.setText(getIntent().getStringExtra("input"));
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.bt_name_confirm)
    public void onViewClicked() {
        setResult(RESULT_OK, new Intent().putExtra("inputResult", etNameName.getText().toString().trim()));
        finish();
    }
}
