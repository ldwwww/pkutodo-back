package edu.pku.pkutodobackend.service.Impl;

import edu.pku.pkutodobackend.enums.ExceptionEnum;
import edu.pku.pkutodobackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/5 15:57
 **/

@Service
public class EmailServiceImpl implements EmailService {

    private Integer userVerificationCode = null;

    @Autowired
    JavaMailSender jms;

    //读取配置文件邮箱账号参数
    @Value("${spring.mail.username}")
    private String sender;
    @Override
    public ExceptionEnum sendEmail(String email) {
        Integer userVerificationCode = new Random().nextInt(999999);
        try {
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();

            //发送者
            mainMessage.setFrom(sender);

            //接收者
            mainMessage.setTo(email);

            //发送的标题
            mainMessage.setSubject("邮箱验证");

            //发送的内容
            String msg = "您好！" + email + ",您正在使用邮箱验证，验证码：" + userVerificationCode + "。";
            mainMessage.setText(msg);

            //发送邮件
            jms.send(mainMessage);

            //下面是加入缓存，以便于进行邮箱验证
            this.userVerificationCode = userVerificationCode;
            System.out.println(this.userVerificationCode);

        } catch(Exception e) {
            return ExceptionEnum.ERROR;
        }
            return ExceptionEnum.SUCCESS;
        }

    @Override
    public ExceptionEnum verificationEmail(int code) {
        if (this.userVerificationCode == null){
            return ExceptionEnum.USER_CODE_NOT_EXIST;
        } else if(this.userVerificationCode.equals(code)){
            return ExceptionEnum.USER_CODE_ERROR;
        }
        return ExceptionEnum.SUCCESS;
    }
}
