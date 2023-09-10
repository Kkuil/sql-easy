package com.kkuil.sqleasy.controller;

import com.kkuil.sqleasy.anotations.AuthLogin;
import com.kkuil.sqleasy.model.bo.MapDataInTokenBO;
import com.kkuil.sqleasy.model.dto.userCommon.UserLoginDTO;
import com.kkuil.sqleasy.model.dto.userCommon.UserRegistryDTO;
import com.kkuil.sqleasy.model.vo.UserAuthInfoVO;
import com.kkuil.sqleasy.service.IUserCommonService;
import com.kkuil.sqleasy.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kkuil
 * @Date 2023/9/3 16:34
 * @Description 用户控制器
 */
@RestController
@Slf4j
public class UserCommonController {

    @Resource
    private IUserCommonService userCommonService;

    /**
     * 登录接口
     *
     * @param userLoginDTO 用户登录信息
     * @return token
     */
    @PostMapping("/login")
    @Operation(summary = "登录", description = "登录")
    @Parameter(name = "userLoginDTO", description = "用户登录信息")
    public ResultUtil<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        return userCommonService.login(userLoginDTO);
    }

    /**
     * 注册接口
     *
     * @param userRegistryDTO 用户注册信息
     * @return token
     */
    @PostMapping("/registry")
    @Operation(summary = "注册", description = "注册")
    @Parameter(name = "userRegistryDTO", description = "用户注册信息")
    public ResultUtil<Boolean> register(@RequestBody UserRegistryDTO userRegistryDTO) {
        return userCommonService.register(userRegistryDTO);
    }

    /**
     * 获取用户信息接口
     *
     * @return 用户信息
     */
    @PostMapping("/auth")
    @Operation(summary = "获取用户信息", description = "获取用户信息")
    @AuthLogin
    public ResultUtil<UserAuthInfoVO> auth(HttpServletResponse response) {
        return userCommonService.auth(response);
    }
}
