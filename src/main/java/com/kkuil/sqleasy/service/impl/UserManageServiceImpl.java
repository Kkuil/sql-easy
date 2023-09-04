package com.kkuil.sqleasy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkuil.sqleasy.mapper.UserMapper;
import com.kkuil.sqleasy.model.entity.User;
import com.kkuil.sqleasy.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description UserManageServiceImpl
 */
@Service
public class UserManageServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
