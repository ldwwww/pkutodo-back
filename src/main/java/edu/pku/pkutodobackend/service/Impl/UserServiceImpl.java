package edu.pku.pkutodobackend.service.Impl;

import edu.pku.pkutodobackend.enums.ExceptionEnum;
import edu.pku.pkutodobackend.mapper.UserMapper;
import edu.pku.pkutodobackend.model.User;
import edu.pku.pkutodobackend.model.UserExample;
import edu.pku.pkutodobackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/5 21:54
 **/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty()){
            return null;
        }
        String token = "111111";
        return token;
    }

    @Override
    public ExceptionEnum register(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(user.getUsername());
        if (!userMapper.selectByExample(example).isEmpty()){
            return ExceptionEnum.USERNAME_EXIST;
        } else{
            userMapper.insert(user);
            return ExceptionEnum.SUCCESS;
        }
    }

    @Override
    public boolean isEmailExist(String email) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);
        return !userMapper.selectByExample(example).isEmpty();
    }
}
