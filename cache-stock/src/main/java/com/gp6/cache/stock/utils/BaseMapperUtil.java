package com.gp6.cache.stock.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper(集成此类可以使用通用Mapper)
 *
 * @author gp6
 * @date 2019-09-24
 */
public interface BaseMapperUtil<T> extends Mapper<T>, MySqlMapper<T> {
}
