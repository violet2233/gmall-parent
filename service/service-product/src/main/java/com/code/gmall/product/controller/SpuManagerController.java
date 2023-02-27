package com.code.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.gmall.common.result.Result;
import com.code.gmall.model.product.SpuInfo;
import com.code.gmall.product.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SpuManagerController
 * @Description
 * @Author violet2233
 * @Date 2023/2/27 19:27
 * @Version v1.0
 */

@RestController
@RequestMapping("/admin/product")
@Api(tags = "商品Spu管理接口")
public class SpuManagerController {

    @Resource
    private ManagerService managerService;


    /**
     * 根据三级分类查询Spu分页列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("{page}/{limit}")
    @ApiOperation("根据三级分类查询Spu分页列表")
    public Result getSpuInfoPage(@PathVariable Long page, @PathVariable Long limit, SpuInfo spuInfo) {

        Page<SpuInfo> spuInfoPage = new Page<>(page,limit);

        IPage<SpuInfo> spuInfoIPage = managerService.getSpuInfoPage(spuInfo,spuInfoPage);

        return Result.ok(spuInfoIPage);


    }
}
