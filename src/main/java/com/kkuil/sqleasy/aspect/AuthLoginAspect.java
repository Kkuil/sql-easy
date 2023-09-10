package com.kkuil.sqleasy.aspect;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.kkuil.sqleasy.exception.UnAuthorizationException;
import com.kkuil.sqleasy.model.bo.MapDataInTokenBO;
import com.kkuil.sqleasy.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;
import static com.kkuil.sqleasy.constant.UserConst.*;

/**
 * @Author Kkuil
 * @Date 2023/9/4 9:54
 * @Description 权限切面类
 */
@Aspect
@Component
public class AuthLoginAspect {

    /**
     * 用户信息
     */
    public static final ThreadLocal<MapDataInTokenBO> USER_THREAD_LOCAL = new ThreadLocal<>();

    @Pointcut("@annotation(com.kkuil.sqleasy.anotations.AuthLogin)")
    public void authLoginAspect() {
    }

    @Around("authLoginAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader(TOKEN_KEY_IN_HEADER);
        if (ObjectUtil.isEmpty(token)) {
            throw new UnAuthorizationException();
        }
        try {
            // 验签
            // 去除前缀
            token = StrUtil.replace(token, TOKEN_KEY_IN_HEADER_PREFIX, "");
            Claims parseToken = JwtUtil.parse(token, USER_TOKEN_SECRET);
            String username = parseToken.get("username").toString();
            if (EMPTY_STR.equals(username)) {
                throw new UnAuthorizationException();
            }
            MapDataInTokenBO userInfo = MapDataInTokenBO.builder().username(username).build();
            USER_THREAD_LOCAL.set(userInfo);
        } catch (Exception e) {
            throw new UnAuthorizationException("token已失效或无效");
        }
        return point.proceed();
    }
}
