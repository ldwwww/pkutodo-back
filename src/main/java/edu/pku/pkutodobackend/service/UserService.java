package edu.pku.pkutodobackend.service;

import edu.pku.pkutodobackend.enums.ExceptionEnum;
import edu.pku.pkutodobackend.model.User;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/5 21:53
 **/
public interface UserService {
    String login(String username, String password);
    ExceptionEnum register(User User);
    boolean isEmailExist(String email);
}
