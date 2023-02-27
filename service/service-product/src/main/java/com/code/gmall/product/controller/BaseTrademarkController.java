package com.code.gmall.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.code.gmall.common.result.Result;
import com.code.gmall.model.product.BaseTrademark;
import com.code.gmall.product.service.BaseTrademarkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName BaseTrademarkController
 * @Description
 * @Author violet2233
 * @Date 2023/2/27 20:35
 * @Version v1.0
 */

@RestController
@RequestMapping("/admin/product/baseTrademark")
@Api(tags = "品牌管理接口")
public class BaseTrademarkController {

    @Resource
    private BaseTrademarkService baseTrademarkService;

    @GetMapping("/{page}/{limit}")
    @ApiOperation("品牌分页列表")
    public Result getBaseTrademarkPage(@PathVariable Long page, @PathVariable Long limit) {


        Page<BaseTrademark> baseTrademarkPage = new Page<>(page, limit);
        IPage<BaseTrademark> baseTrademarkIPage = baseTrademarkService.getBaseTrademarkPage(baseTrademarkPage);
        return Result.ok(baseTrademarkIPage);
    }


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation("根据id查询")
    public Result getById(@PathVariable Long id) {
        BaseTrademark baseTrademark = baseTrademarkService.getById(id);
        return Result.ok(baseTrademark);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    @ApiOperation("根据id删除")
    public Result removeById(@PathVariable Long id){
        boolean b = baseTrademarkService.removeById(id);

        return Result.ok(b);
    }


    /**
     * 保存品牌信息
     * @param baseTrademark
     * @return
     */
    @PostMapping("/save")
    @ApiOperation("保存品牌信息")
    public Result save(@RequestBody BaseTrademark baseTrademark){
        boolean save = baseTrademarkService.save(baseTrademark);
        return Result.ok(save);
    }

    /**
     * 更新品牌信息
     * @param baseTrademark
     * @return
     */
    @PutMapping("/update")
    @ApiOperation("更新品牌信息")
    public Result update(@RequestBody BaseTrademark baseTrademark){
        boolean b = baseTrademarkService.updateById(baseTrademark);
        return Result.ok(b);
    }
}
