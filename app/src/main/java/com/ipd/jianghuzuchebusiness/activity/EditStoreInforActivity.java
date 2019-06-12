package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.VehiclePhotoAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.CaptchaBean;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;
import com.ipd.jianghuzuchebusiness.bean.UploadImgBean;
import com.ipd.jianghuzuchebusiness.bean.VehiclePhotoBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.EditStoreInforContract;
import com.ipd.jianghuzuchebusiness.presenter.EditStoreInforPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.wildma.pictureselector.PictureSelector;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuchebusiness.activity.FillInPaperActivity.getImageRequestBody;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_93;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_94;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_95;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;

/**
 * Description ：编辑门店资料
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class EditStoreInforActivity extends BaseActivity<EditStoreInforContract.View, EditStoreInforContract.Presenter> implements EditStoreInforContract.View {

    @BindView(R.id.tv_edit_store_infor_top)
    TopView tvEditStoreInforTop;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.ll_store_name)
    LinearLayout llStoreName;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.ll_store_path)
    LinearLayout llStorePath;
    @BindView(R.id.tv_store_phone)
    TextView tvStorePhone;
    @BindView(R.id.ll_store_phone)
    LinearLayout llStorePhone;
    @BindView(R.id.cb_charge_one)
    CheckBox cbChargeOne;
    @BindView(R.id.cb_charge_two)
    CheckBox cbChargeTwo;
    @BindView(R.id.cb_charge_three)
    CheckBox cbChargeThree;
    @BindView(R.id.ll_charge_service)
    LinearLayout llChargeService;
    @BindView(R.id.rv_edit_store_infor)
    RecyclerView rvEditStoreInfor;
    @BindView(R.id.bt_edit_store_infor)
    Button btEditStoreInfor;

    private StoreInforBean.DataBean.SelectStoreBean selectStoreBean = new StoreInforBean.DataBean.SelectStoreBean();
    private List<ChargeBean.DataBean.ChargeListBean> chargeListBean;
    private String imgPath;
    private VehiclePhotoAdapter vehiclePhotoAdapter;
    private List<VehiclePhotoBean> list = new ArrayList<>();
    private StringBuffer imgPaths = new StringBuffer();
    private StringBuffer chargePaths = new StringBuffer();
    private VehiclePhotoBean clickDataBean = new VehiclePhotoBean();

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_store_infor;
    }

    @Override
    public EditStoreInforContract.Presenter createPresenter() {
        return new EditStoreInforPresenter(this);
    }

    @Override
    public EditStoreInforContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvEditStoreInforTop);

        selectStoreBean = getIntent().getParcelableExtra("select_store_bean");
        chargeListBean = getIntent().getParcelableArrayListExtra("charge_list");

        tvStoreName.setText(selectStoreBean.getStoreName());
        tvStorePath.setText(selectStoreBean.getDescAddress());
        tvStorePhone.setText(selectStoreBean.getContactsPhone());
        cbChargeOne.setText(chargeListBean.get(0).getTitle());
        cbChargeTwo.setText(chargeListBean.get(1).getTitle());
        cbChargeThree.setText(chargeListBean.get(2).getTitle());

        String[] chargeId = selectStoreBean.getChargeId().split(",");
        if (!selectStoreBean.getChargeId().equals("")) {
            for (int i = 0; i < chargeId.length; i++) {
                if (chargeId[i].equals(chargeListBean.get(i).getChargeId() + "")) {
                    switch (i) {
                        case 0:
                            cbChargeOne.setChecked(true);
                            break;
                        case 1:
                            cbChargeTwo.setChecked(true);
                            break;
                        case 2:
                            cbChargeThree.setChecked(true);
                            break;
                    }
                }
            }
        }

        //设置RecyclerView方向和是否反转
        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvEditStoreInfor.setLayoutManager(NotUseList);
        rvEditStoreInfor.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvEditStoreInfor.setItemAnimator(new DefaultItemAnimator()); //默认动画

        //初始化数据
        String[] strs = selectStoreBean.getPicPath().split(",");
        for (int i = 0; i < strs.length; i++) {
            clickDataBean.setName(strs[i].toString());
            list.add(clickDataBean);
        }
        list.add(getImageData());
        vehiclePhotoAdapter = new VehiclePhotoAdapter(list);
        rvEditStoreInfor.setAdapter(vehiclePhotoAdapter);
    }

    @Override
    public void initListener() {
        vehiclePhotoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                clickDataBean = list.get(position);
                switch (view.getId()) {
                    case R.id.iv_household_registration:
                        if (TextUtils.isEmpty(clickDataBean.getName())) {
                            selectPhoto();
                        } else {
                            BigImageActivity.launch(EditStoreInforActivity.this, clickDataBean.getName());
                        }
                        break;
                    case R.id.iv_household_registration_del:
                        list.remove(position);
                        vehiclePhotoAdapter.notifyItemRemoved(position);
                        break;
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_93:
                    tvStoreName.setText(data.getStringExtra("inputResult"));
                    break;
                case REQUEST_CODE_94:
                    tvStorePath.setText(data.getStringExtra("inputResult"));
                    break;
                case REQUEST_CODE_95:
                    tvStorePhone.setText(data.getStringExtra("inputResult"));
                    break;
                case PictureSelector.SELECT_REQUEST_CODE:
                    String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                    TreeMap<String, RequestBody> map = new TreeMap<>();
                    map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(picturePath));
                    getPresenter().getUploadImg("3", map, true, false);
                    break;
            }
        }
    }

    private VehiclePhotoBean getImageData() {
        //初始化数据
        VehiclePhotoBean dataBean = new VehiclePhotoBean();
        return dataBean;
    }

    private void selectPhoto() {
        /**
         * create()方法参数一是上下文，在activity中传activity.this，在fragment中传fragment.this。参数二为请求码，用于结果回调onActivityResult中判断
         * selectPicture()方法参数分别为 是否裁剪、裁剪后图片的宽(单位px)、裁剪后图片的高、宽比例、高比例。都不传则默认为裁剪，宽200，高200，宽高比例为1：1。
         */
        PictureSelector.create(this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false, 200, 200, 1, 1);
    }

    @Override
    public void resultEditStoreInfor(CaptchaBean data) {
        ToastUtil.showShortToast(data.getMsg());
        setResult(RESULT_OK, new Intent().putExtra("refresh", 1));
        finish();
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        imgPath = data.getData();
        clickDataBean.setName(imgPath);
        list.add(getImageData());
        vehiclePhotoAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.ll_store_name, R.id.ll_store_path, R.id.ll_store_phone, R.id.bt_edit_store_infor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_store_name:
                startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 0).putExtra("input", selectStoreBean.getStoreName()), REQUEST_CODE_93);
                break;
            case R.id.ll_store_path:
                startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 1).putExtra("input", selectStoreBean.getDescAddress()), REQUEST_CODE_94);
                break;
            case R.id.ll_store_phone:
                startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 2).putExtra("input", selectStoreBean.getContactsPhone()), REQUEST_CODE_95);
                break;
            case R.id.bt_edit_store_infor:
                if (list.size() < 4 || list.size() > 10) {
                    ToastUtil.showShortToast("最小上传图片为3张，最大为9张！");
                } else {
                    list.remove(list.size() - 1);
                    for (int i = 0; i < list.size(); i++) {
                        if (i < list.size() - 1)
                            imgPaths.append(list.get(i).getName() + ",");
                        else
                            imgPaths.append(list.get(i).getName());
                    }

                    List<String> charge = new ArrayList<>();
                    if (cbChargeOne.isChecked())
                        charge.add(chargeListBean.get(0).getChargeId() + "");
                    if (cbChargeOne.isChecked())
                        charge.add(chargeListBean.get(1).getChargeId() + "");
                    if (cbChargeOne.isChecked())
                        charge.add(chargeListBean.get(2).getChargeId() + "");

                    for (int i = 0; i < charge.size(); i++) {
                        if (i < charge.size() - 1)
                            chargePaths.append(charge.get(i) + ",");
                        else
                            chargePaths.append(charge.get(i));
                    }
                    TreeMap<String, String> returnCarMap = new TreeMap<>();
                    returnCarMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                    returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                    returnCarMap.put("storeName", tvStoreName.getText().toString().trim());
                    returnCarMap.put("descAddress", tvStorePath.getText().toString().trim());
                    returnCarMap.put("contactsPhone", tvStorePhone.getText().toString().trim());
                    returnCarMap.put("chargeId", chargePaths + "");
                    returnCarMap.put("picPath", imgPaths + "");
                    getPresenter().getEditStoreInfor(returnCarMap, true, false);
                }
                break;
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
