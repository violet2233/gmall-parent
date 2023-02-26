package com.code.gmall.product.controller;

import com.code.gmall.common.result.Result;
import com.code.gmall.model.product.BaseAttrInfo;
import com.code.gmall.model.product.BaseCategory1;
import com.code.gmall.model.product.BaseCategory2;
import com.code.gmall.model.product.BaseCategory3;
import com.code.gmall.product.mapper.BaseCategory1Mapper;
import com.code.gmall.product.service.ManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BaseManageController
 * @Description 商品基础属性接口
 * @Author violet2233
 * @Date 2023/2/26 17:33
 * @Version v1.0
 */

@Api(tags = "商品基础属性接口")
@RestController
@RequestMapping("admin/product")

public class BaseManageController {

    @Resource
    private ManageService manageService;


    /**
     * 查询所有的一级分类信息
     *
     * @return
     */
    @ApiOperation("查询所有的一级分类信息")
    @GetMapping("getCategory1")
    public Result<List<BaseCategory1>> getCategory1() {
        List<BaseCategory1> baseCategory1List = manageService.getCategory1();
        return Result.ok(baseCategory1List);
    }

    /**
     * 根据一级分类Id 查询二级分类数据
     *
     * @param category1Id
     * @return
     */
    @GetMapping("getCategory2/{category1Id}")
    @ApiOperation("根据一级分类Id 查询二级分类数据")
    public Result<List<BaseCategory2>> getCategory2(@PathVariable Long category1Id) {
        List<BaseCategory2> BaseCategory2List = manageService.getCategory2(category1Id);
        return Result.ok(BaseCategory2List);

    }

    /**
     * 根据二级分类Id 查询三级分类数据
     *
     * @param category2Id
     * @return
     */
    @GetMapping("getCategory3/{category2Id}")
    @ApiOperation("根据一级分类Id 查询二级分类数据")
    public Result<List<BaseCategory3>> getCategory3(@PathVariable Long category2Id) {
        List<BaseCategory3> BaseCategory3List = manageService.getCategory3(category2Id);
        return Result.ok(BaseCategory3List);

    }

    /**
     * 根据分类id获取属性列表
     *
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */

    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    @ApiOperation("根据分类id获取属性列表")
    public Result<List<BaseAttrInfo>> getAttrInfoList(@PathVariable Long category1Id,
                                                      @PathVariable Long category2Id,
                                                      @PathVariable Long category3Id) {


        List<BaseAttrInfo> baseAttrInfoList = manageService.getAttrInfoList(category1Id, category2Id, category3Id);
        return Result.ok(baseAttrInfoList);
    }


}
