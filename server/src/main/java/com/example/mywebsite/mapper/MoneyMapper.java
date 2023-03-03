package com.example.mywebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mywebsite.entity.Money;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cls1277
 * @date 2022-10-03 0:06
 */
@Mapper
public interface MoneyMapper extends BaseMapper<Money> {
}
