package com.code.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.gmall.model.product.BaseAttrInfo;
import com.code.gmall.model.product.BaseCategory1;
import com.code.gmall.model.product.BaseCategory2;
import com.code.gmall.model.product.BaseCategory3;
import com.code.gmall.product.mapper.BaseAttrInfoMapper;
import com.code.gmall.product.mapper.BaseCategory1Mapper;
import com.code.gmall.product.mapper.BaseCategory2Mapper;
import com.code.gmall.product.mapper.BaseCategory3Mapper;
import com.code.gmall.product.service.ManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ManageServiceImpl
 * @Description
 * @Author violet2233
 * @Date 2023/2/26 17:48
 * @Version v1.0
 */

@Service
public class ManageServiceImpl implements ManageService {

    @Resource
    private BaseCategory1Mapper baseCategory1Mapper;

    @Resource
    private BaseCategory2Mapper baseCategory2Mapper;

    @Resource
    private BaseCategory3Mapper baseCategory3Mapper;

    @Resource
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Override
    public List<BaseCategory1> getCategory1() {

        return baseCategory1Mapper.selectList(null);
    }

    @Override
    public List<BaseCategory2> getCategory2(Long category1Id) {

        QueryWrapper<BaseCategory2> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category1_id", category1Id);
        return baseCategory2Mapper.selectList(queryWrapper);
    }

    @Override
    public List<BaseCategory3> getCategory3(Long category2Id) {
        QueryWrapper<BaseCategory3> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category2_id", category2Id);
        return baseCategory3Mapper.selectList(queryWrapper);
    }

    @Override
    public List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id) {

        return baseAttrInfoMapper.selectAttrInfoList(category1Id,category2Id,category3Id);
    }
}
