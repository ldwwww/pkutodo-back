package edu.pku.pkutodobackend.controller;

import cn.hutool.http.server.HttpServerRequest;
import edu.pku.pkutodobackend.dto.EmailDTO;
import edu.pku.pkutodobackend.dto.LoginDTO;
import edu.pku.pkutodobackend.dto.RegisterDTO;
import edu.pku.pkutodobackend.enums.ExceptionEnum;
import edu.pku.pkutodobackend.model.User;
import edu.pku.pkutodobackend.service.EmailService;
import edu.pku.pkutodobackend.service.UserService;
import edu.pku.pkutodobackend.utils.Result;
import edu.pku.pkutodobackend.vo.DataVO;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author：liudawei
 * @Description: UserController
 * @DateTime:2024/10/5 21:50
 **/

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    @ResponseBody
    public DataVO sendEmail(@RequestBody EmailDTO emailDTO) {
        String email = emailDTO.getEmail();
        if(userService.isEmailExist(email)){
            return Result.error(ExceptionEnum.USER_EMAIL_EXIST);
        }
        ExceptionEnum send = emailService.sendEmail(email);
        if (send != ExceptionEnum.SUCCESS){
            return Result.error(send);
        }
        return Result.success();
    }

    @PostMapping("/register")
    @ResponseBody
    public DataVO register(@RequestBody RegisterDTO registerDTO){
        ExceptionEnum verify = emailService.verificationEmail(registerDTO.getCode());
        if (verify != ExceptionEnum.SUCCESS){
            return Result.error(verify);
        }
        User newUser = new User();
        newUser.setEmail(registerDTO.getEmail());
        newUser.setUsername(registerDTO.getUsername());
        newUser.setPassword(registerDTO.getPassword());
        newUser.setRegisterdate(new java.util.Date());
        ExceptionEnum register = userService.register(newUser);
        if (register == ExceptionEnum.USERNAME_EXIST){
            return Result.error(register);
        }
        return Result.success();
    }

    @PostMapping("/login")
    @ResponseBody
    public DataVO login(@RequestBody LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();
        String token = userService.login(username, password);
        if(token == null)
            return Result.error(ExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        return Result.successToArray("token", token);
    }

//    //  测试打印请求内容
//    @PostMapping("/login")
//    @ResponseBody
//    public void login(ServletRequest request) throws IOException {
//        String r = getRequestBody(request);
//        System.out.println(r);
//    }
//
//    private String getRequestBody(ServletRequest request) throws IOException {
//        StringBuilder sb = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//            }
//        }
//        return sb.toString();
//    }
}


/**
 * TODO
 * redis缓存token和验证码
 * 用户密码的加密
 */