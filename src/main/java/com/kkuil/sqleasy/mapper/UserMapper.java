package com.kkuil.sqleasy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkuil.sqleasy.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Kkuil
 * @Date 2023/07/29 20:00
 * @Description UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
