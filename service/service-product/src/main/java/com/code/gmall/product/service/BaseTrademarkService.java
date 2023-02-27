package com.code.gmall.product.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.code.gmall.model.product.BaseTrademark;

/**
* @author violet2233
* @description 针对表【base_trademark(品牌表)】的数据库操作Service
* @createDate 2023-02-27 20:46:18
*/
public interface BaseTrademarkService extends IService<BaseTrademark> {


    /**
     * 品牌分页列表
     * @param baseTrademarkPage
     * @return
     */
    IPage<BaseTrademark> getBaseTrademarkPage(Page<BaseTrademark> baseTrademarkPage);
}
