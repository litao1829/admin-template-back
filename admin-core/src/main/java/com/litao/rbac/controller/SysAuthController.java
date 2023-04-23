package com.litao.rbac.controller;

import com.litao.common.utils.Result;
import com.litao.rbac.service.SysAuthService;
import com.litao.rbac.service.SysCaptchaService;
import com.litao.rbac.vo.SysAccountLoginVO;
import com.litao.rbac.vo.SysCaptchaVO;
import com.litao.rbac.vo.SysTokenVO;
import com.litao.security.utils.TokenUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 认证接口
 *
 * @author
 **/

@RestController
@RequestMapping("sys/auth")
@Tag(name = "认证管理")
@AllArgsConstructor
public class SysAuthController {
    private final SysAuthService sysAuthService;
    private final SysCaptchaService sysCaptchaService;


    @GetMapping("captcha")
    @Operation(summary = "验证码")
    public Result<SysCaptchaVO> captcha(){
        SysCaptchaVO generate = sysCaptchaService.generate();
        return Result.ok(generate);
    }

    @PostMapping("login")
    @Operation(summary = "账号密码登录")
    public Result<SysTokenVO> login(@RequestBody SysAccountLoginVO login) {
        SysTokenVO token = sysAuthService.loginByAccount(login);
        return Result.ok(token);
    }

    @PostMapping("logout")
    @Operation(summary = "退出")
    public Result<String> logout(HttpServletRequest request) {
        sysAuthService.logout(TokenUtils.getAccessToken(request));
        return Result.ok();
    }
}
