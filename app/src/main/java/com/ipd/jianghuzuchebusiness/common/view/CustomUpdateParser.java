package com.ipd.jianghuzuchebusiness.common.view;

import com.google.gson.Gson;
import com.ipd.jianghuzuchebusiness.bean.ModifyVersionBean;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.proxy.IUpdateParser;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.PACKAGE_NAME;
import static com.ipd.jianghuzuchebusiness.utils.AppUtils.getAppVersionName;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/7/3.
 */
public class CustomUpdateParser implements IUpdateParser {
    @Override
    public UpdateEntity parseJson(String json) throws Exception {
        ModifyVersionBean result = new Gson().fromJson(json, ModifyVersionBean.class);
        if (result != null) {
            boolean updateEntity = false;
            if (!getAppVersionName(ApplicationUtil.getContext(), PACKAGE_NAME).equals(result.getData().getVersionYes().getVersionNo())) {
                updateEntity = true;
            }
            return new UpdateEntity()
                    .setHasUpdate(updateEntity)//result.getData().getVersionYes().getNews() == 1 ? false : true)
                    .setForce(true)//result.getData().getVersionYes().getModify() == 1 ? true : false)
                    .setIsIgnorable(false)
//                    .setVersionCode(2)
                    .setVersionName(result.getData().getVersionYes().getVersionNo())
                    .setUpdateContent(result.getData().getVersionYes().getIntro())
                    .setIsAutoInstall(true)
                    .setDownloadUrl("http://jhkc.hanyu365.com.cn/rentCarGov/jianghuzuche_business_v" + getAppVersionName(ApplicationUtil.getContext(), PACKAGE_NAME) + "_baidu.apk");
        }
        return null;
    }
}
