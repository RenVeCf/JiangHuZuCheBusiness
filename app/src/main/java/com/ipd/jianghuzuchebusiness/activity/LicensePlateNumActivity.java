package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description ：车牌号
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class LicensePlateNumActivity extends BaseActivity {

    @BindView(R.id.tv_license_plate_num_top)
    TopView tvLicensePlateNumTop;
    @BindView(R.id.et_license_plate_num)
    EditText etLicensePlateNum;
    @BindView(R.id.bt_license_plate_num)
    Button btLicensePlateNum;

    private String carNum = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_license_plate_num;
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
        ImmersionBar.setTitleBar(this, tvLicensePlateNumTop);

        carNum = getIntent().getStringExtra("car_num");
        if (!carNum.equals(""))
            etLicensePlateNum.setText(carNum);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.bt_license_plate_num)
    public void onViewClicked() {
        if (!etLicensePlateNum.getText().toString().trim().equals("")) {
            setResult(RESULT_OK, new Intent()
                    .putExtra("license_plate_num", etLicensePlateNum.getText().toString().trim()));
            finish();
        } else
            ToastUtil.showLongToast("请填写车牌号！");
    }
}
