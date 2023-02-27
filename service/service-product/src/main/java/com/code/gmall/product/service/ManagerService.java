package com.code.gmall.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.gmall.model.product.*;

import java.util.List;

/**
 * @ClassName ManageService
 * @Description
 * @Author violet2233
 * @Date 2023/2/26 17:48
 * @Version v1.0
 */

public interface ManagerService {

    /**
     * 查询所有的一级分类信息
     * @return
     */
    List<BaseCategory1> getCategory1();

    /**
     * 根据一级分类Id 查询二级分类数据
     * @param category1Id
     * @return
     */
    List<BaseCategory2> getCategory2(Long category1Id);


    /**
     * 根据二级分类Id 查询三级分类数据
     * @param category2Id
     * @return
     */
    List<BaseCategory3> getCategory3(Long category2Id);

    /**
     * 根据分类id获取属性列表
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

    /**
     * 保存-修改平台属性
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据attrId查询平台属性值对象
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(Long attrId);

    /**
     * 根据attrId查询属性
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(Long attrId);


    /**
     * 根据三级分类查询Spu分页列表
     * @param spuInfo
     * @param spuInfoPage
     * @return
     */
    IPage<SpuInfo> getSpuInfoPage(SpuInfo spuInfo, Page<SpuInfo> spuInfoPage);
}
