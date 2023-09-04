package com.kkuil.sqleasy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkuil.sqleasy.exception.NecessaryFieldsIsEmptyException;
import com.kkuil.sqleasy.model.bo.MapDataInTokenBO;
import com.kkuil.sqleasy.model.dto.userCommon.UserLoginDTO;
import com.kkuil.sqleasy.model.dto.userCommon.UserRegistryDTO;
import com.kkuil.sqleasy.model.entity.User;
import com.kkuil.sqleasy.service.IUserCommonService;
import com.kkuil.sqleasy.service.IUserService;
import com.kkuil.sqleasy.utils.JwtUtils;
import com.kkuil.sqleasy.utils.ResultUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.kkuil.sqleasy.constant.UserConst.*;

/**
 * @Author Kkuil
 * @Date 2023/9/3 16:44
 * @Description 用户服务类
 */
@Service
@Slf4j
public class UserCommonServiceImpl implements IUserCommonService {

    @Resource
    private IUserService userService;

    /**
     * 登录
     *
     * @param userLoginDTO 用户登录信息
     * @return token
     */
    @Override
    public ResultUtil<String> login(UserLoginDTO userLoginDTO) {
        boolean isAllNotEmpty = ObjectUtil.isAllNotEmpty(userLoginDTO);
        if (!isAllNotEmpty) {
            throw new NecessaryFieldsIsEmptyException("必填字段为空异常");
        }
        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        User user = userService.getOne(userQueryWrapper);
        if (user == null) {
            return ResultUtil.error("用户不存在", null);
        }
        String pwdInTable = user.getPassword();
        String pwdInForm = DigestUtil.md5Hex(password + USER_ENCRYPT_VALUE);
        log.info("pwdInTable: {}", pwdInTable);
        log.info("pwdInForm: {}", pwdInForm);
        MapDataInTokenBO mapDataInTokenBO = MapDataInTokenBO.builder().username(username).build();
        if (!pwdInTable.equals(pwdInForm)) {
            return ResultUtil.error("密码错误", null);
        }
        Map<String, Object> tokenMap = new HashMap<>(8);
        tokenMap = BeanUtil.beanToMap(mapDataInTokenBO, tokenMap, false, true);
        String token = JwtUtils.create(tokenMap, USER_TOKEN_SECRET, USER_TOKEN_TTL);
        return ResultUtil.success("登录成功", token);
    }

    /**
     * 注册
     *
     * @param userRegistryDTO 用户注册信息
     * @return 是否注册成功
     */
    @Override
    public ResultUtil<Boolean> registry(UserRegistryDTO userRegistryDTO) {
        boolean isAllNotEmpty = ObjectUtil.isAllNotEmpty(userRegistryDTO);
        if (!isAllNotEmpty) {
            throw new NecessaryFieldsIsEmptyException("必填字段为空异常");
        }
        String username = userRegistryDTO.getUsername();
        String password = userRegistryDTO.getPassword();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", username);
        User user = userService.getOne(userQueryWrapper);
        if (user != null) {
            return ResultUtil.error("该用户名已被注册，请重新输入", false);
        }
        // md5(password + 盐值)
        password = DigestUtil.md5Hex(password + USER_ENCRYPT_VALUE);
        User newUser = User.builder()
                .username(username)
                .password(password)
                .build();
        userService.save(newUser);
        return ResultUtil.success("注册成功", true);
    }
}
