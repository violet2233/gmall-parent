package com.code.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.code.gmall.model.product.BaseTrademark;
import com.code.gmall.product.mapper.BaseTrademarkMapper;
import com.code.gmall.product.service.BaseTrademarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author violet2233
 * @description 针对表【base_trademark(品牌表)】的数据库操作Service实现
 * @createDate 2023-02-27 20:46:18
 */
@Service
public class BaseTrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark>
        implements BaseTrademarkService {

    @Resource
    private BaseTrademarkMapper baseTrademarkMapper;

    @Override
    public IPage<BaseTrademark> getBaseTrademarkPage(Page<BaseTrademark> baseTrademarkPage) {

        QueryWrapper<BaseTrademark> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        return baseTrademarkMapper.selectPage(baseTrademarkPage, queryWrapper);

    }
}




