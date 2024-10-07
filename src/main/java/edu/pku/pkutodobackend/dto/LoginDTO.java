package edu.pku.pkutodobackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/7 10:43
 **/
public class LoginDTO {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
