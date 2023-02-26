package com.code.gmall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.code.gmall.model.product.BaseAttrInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BaseAttrInfoMapper
 * @Description 针对表【base_attr_info(属性表)】的数据库操作Mapper
 * @Author violet2233
 * @Date 2023/2/26 20:44
 * @Version v1.0
 */

public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    /**
     * 根据分类id获取属性列表
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> selectAttrInfoList(@Param("category1Id") Long category1Id, @Param("category2Id") Long category2Id,
                                          @Param("category3Id") Long category3Id);
}
