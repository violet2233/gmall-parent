package com.code.gmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.gmall.common.handler.GlobalExceptionHandler;
import com.code.gmall.model.product.*;
import com.code.gmall.product.mapper.*;
import com.code.gmall.product.service.ManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
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

    @Resource
    private BaseAttrValueMapper baseAttrValueMapper;

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

        return baseAttrInfoMapper.selectAttrInfoList(category1Id, category2Id, category3Id);
    }

    @Override
    //提升事务捕获级别
    @Transactional(rollbackFor = Exception.class)
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        //判断执行添加还是修改
        if (baseAttrInfo.getId() == null) {
            //执行添加操作
            baseAttrInfoMapper.insert(baseAttrInfo);
        } else {
            //执行修改操作
            baseAttrInfoMapper.updateById(baseAttrInfo);
        }

        //删除旧的baseAttrValue重新添加
        QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attr_id", baseAttrInfo.getId());
        baseAttrValueMapper.delete(queryWrapper);

        //操作base_attr_value
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        if (!CollectionUtils.isEmpty(attrValueList) && attrValueList.size() > 0) {
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValue.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }

    }

    @Override
    public List<BaseAttrValue> getAttrValueList(Long attrId) {
        QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attr_id", attrId);
        return baseAttrValueMapper.selectList(queryWrapper);


    }

    @Override
    public BaseAttrInfo getAttrInfo(Long attrId) {

        QueryWrapper<BaseAttrInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", attrId);
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectOne(queryWrapper);

        baseAttrInfo.setAttrValueList(getAttrValueList(attrId));

        return baseAttrInfo;
    }
}
