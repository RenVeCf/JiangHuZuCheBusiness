package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ImageSelectGridAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.GetCarCommitBean;
import com.ipd.jianghuzuchebusiness.bean.UploadImgBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.FillInPaperContract;
import com.ipd.jianghuzuchebusiness.presenter.FillInPaperPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_90;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_91;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：填写取/退车单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class FillInPaperActivity extends BaseActivity<FillInPaperContract.View, FillInPaperContract.Presenter> implements FillInPaperContract.View, ImageSelectGridAdapter.OnAddPicClickListener {

    @BindView(R.id.tv_fill_in_car_paper_top)
    TopView tvFillInCarPaperTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.ll_license_plate_num)
    LinearLayout llLicensePlateNum;
    @BindView(R.id.ll_vehicle_condition)
    LinearLayout llVehicleCondition;
    @BindView(R.id.bt_confirmation_order)
    Button btConfirmationOrder;
    @BindView(R.id.rv_vehicle_photo)
    RecyclerView rvVehiclePhoto;
    @BindView(R.id.tv_car_num)
    TextView tvCarNum;

    private int paperType;
    private String orderId;
    private String licensePlateNum = ""; //车牌号
    private String statusIds = ""; //车辆状况

    private StringBuffer imgPaths = new StringBuffer();
    private ImageSelectGridAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fill_in_car_paper;
    }

    @Override
    public FillInPaperContract.Presenter createPresenter() {
        return new FillInPaperPresenter(this);
    }

    @Override
    public FillInPaperContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvFillInCarPaperTop);

        paperType = getIntent().getIntExtra("paper_type", 0);
        orderId = getIntent().getStringExtra("order_id");

        switch (paperType) {
            case 0:
                tvTopTitle.setText("填写取车单");
                break;
            case 1:
                tvTopTitle.setText("填写退车单");
                llLicensePlateNum.setVisibility(View.GONE);
                break;
        }

        //设置RecyclerView方向和是否反转
        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvVehiclePhoto.setLayoutManager(NotUseList);
        rvVehiclePhoto.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvVehiclePhoto.setItemAnimator(new DefaultItemAnimator()); //默认动画

        //初始化数据
        mAdapter = new ImageSelectGridAdapter(this, this);
        mAdapter.setSelectMax(9);
        rvVehiclePhoto.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener(new ImageSelectGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                PictureSelector.create(FillInPaperActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, mAdapter.mList);
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
                case REQUEST_CODE_90:
                    licensePlateNum = data.getStringExtra("license_plate_num");
                    tvCarNum.setText(licensePlateNum);
                    break;
                case REQUEST_CODE_91:
                    statusIds = data.getStringExtra("status_ids");
                    break;
                case PictureConfig.CHOOSE_REQUEST:
                    for (int i = 0; i < PictureSelector.obtainMultipleResult(data).size(); i++) {
                        TreeMap<String, RequestBody> map = new TreeMap<>();
                        map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(PictureSelector.obtainMultipleResult(data).get(i).getCompressPath()));
                        getPresenter().getUploadImg("3", map, true, false);
                    }
                    break;
            }
        }
    }

    public static RequestBody getImageRequestBody(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return RequestBody.create(MediaType.parse(options.outMimeType), new File(filePath));
    }

    @OnClick({R.id.ll_license_plate_num, R.id.ll_vehicle_condition, R.id.bt_confirmation_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_license_plate_num:
                if (isClickUtil.isFastClick()) {
                    if (!licensePlateNum.equals(""))
                        startActivityForResult(new Intent(this, LicensePlateNumActivity.class).putExtra("car_num", licensePlateNum), REQUEST_CODE_90);
                    else
                        startActivityForResult(new Intent(this, LicensePlateNumActivity.class).putExtra("car_num", ""), REQUEST_CODE_90);
                }
                break;
            case R.id.ll_vehicle_condition:
                startActivityForResult(new Intent(this, VehicleConditionActivity.class).putExtra("order_id", orderId).putExtra("paper_type", paperType), REQUEST_CODE_91);
                break;
            case R.id.bt_confirmation_order:
                if (isClickUtil.isFastClick()) {
                    if (mAdapter.mList.size() < 3 || mAdapter.mList.size() > 9) {
                        ToastUtil.showShortToast("最小上传图片为3张，最大为9张！");
                    } else {
                        switch (paperType) {
                            case 0:
                                if (!licensePlateNum.equals("") && !statusIds.equals("")) {
                                    for (int i = 0; i < mAdapter.mList.size(); i++) {
                                        if (i < mAdapter.mList.size() - 1)
                                            imgPaths.append((mAdapter.mList.get(i).getCompressPath() + ",").replaceAll(BASE_LOCAL_URL, ""));
                                        else
                                            imgPaths.append((mAdapter.mList.get(i).getCompressPath()).replaceAll(BASE_LOCAL_URL, ""));
                                    }

                                    TreeMap<String, String> loginMap = new TreeMap<>();
                                    loginMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                                    loginMap.put("orderId", orderId + "");
                                    loginMap.put("plateNumber", licensePlateNum);
                                    loginMap.put("statusIds", statusIds);
                                    loginMap.put("picPath", imgPaths + "");
                                    loginMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                                    getPresenter().getGetCarCommit(loginMap, true, false);
                                } else
                                    ToastUtil.showShortToast("请将资料填写完整");
                                break;
                            case 1:
                                if (!statusIds.equals("")) {
                                    for (int i = 0; i < mAdapter.mList.size(); i++) {
                                        if (i < mAdapter.mList.size() - 1)
                                            imgPaths.append((mAdapter.mList.get(i).getCompressPath() + ",").replaceAll(BASE_LOCAL_URL, ""));
                                        else
                                            imgPaths.append((mAdapter.mList.get(i).getCompressPath()).replaceAll(BASE_LOCAL_URL, ""));
                                    }

                                    TreeMap<String, String> returnCarMap = new TreeMap<>();
                                    returnCarMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                                    returnCarMap.put("orderId", orderId + "");
                                    returnCarMap.put("statusIds", statusIds);
                                    returnCarMap.put("picPath", imgPaths + "");
                                    returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                                    getPresenter().getReturnCarCommit(returnCarMap, true, false);
                                } else
                                    ToastUtil.showShortToast("请将资料填写完整");
                                break;
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void resultGetCarCommit(GetCarCommitBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            setResult(RESULT_OK, new Intent()
                    .putExtra("get_car_result", "1"));
            finish();
        }
    }

    @Override
    public void resultReturnCarCommit(GetCarCommitBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            setResult(RESULT_OK, new Intent()
                    .putExtra("get_car_result", "1"));
            finish();
        }
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        LocalMedia localMedia = new LocalMedia();
        localMedia.setCompressed(true);
        localMedia.setCompressPath(BASE_LOCAL_URL + data.getData());
        mAdapter.setSelectList(localMedia);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAddPicClick() {
        PictureSelector.create(FillInPaperActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .maxSelectNum(9)// 最大图片选择数量 int
                .isCamera(true)
                .compress(true)
                .minimumCompressSize(100)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
