package com.kkuil.sqleasy.service;

import com.kkuil.sqleasy.model.dto.userCommon.UserLoginDTO;
import com.kkuil.sqleasy.model.dto.userCommon.UserRegistryDTO;
import com.kkuil.sqleasy.model.vo.UserAuthInfoVO;
import com.kkuil.sqleasy.utils.ResultUtil;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author Kkuil
 * @Date 2023/9/3 16:40
 * @Description 用户接口
 */
public interface IUserCommonService {

    /**
     * 登录
     *
     * @param userLoginDTO 用户登录信息
     * @return token
     */
    ResultUtil<String> login(UserLoginDTO userLoginDTO);

    /**
     * 注册
     *
     * @param userRegistryDTO 用户注册信息
     * @return 是否注册成功
     */
    ResultUtil<Boolean> register(UserRegistryDTO userRegistryDTO);

    /**
     * 获取用户信息接口
     *
     * @param response HttpServletResponse
     * @return 用户信息
     */
    ResultUtil<UserAuthInfoVO> auth(HttpServletResponse response);
}
