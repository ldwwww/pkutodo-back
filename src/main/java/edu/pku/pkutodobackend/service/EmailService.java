package edu.pku.pkutodobackend.service;

import edu.pku.pkutodobackend.enums.ExceptionEnum;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/5 15:58
 **/
public interface EmailService {
    ExceptionEnum sendEmail(String email);
    ExceptionEnum verificationEmail(int code);
}
