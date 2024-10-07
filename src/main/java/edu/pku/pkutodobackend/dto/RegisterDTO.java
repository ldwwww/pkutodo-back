package edu.pku.pkutodobackend.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author：liudawei
 * @Description:TODO
 * @DateTime:2024/10/7 11:08
 **/
public class RegisterDTO {
    @Getter @Setter
    private String email;
    @Getter @Setter
    private int code;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
    public RegisterDTO(){}

    public RegisterDTO(String email, int code, String username, String password) {
        this.email = email;
        this.code = code;
        this.username = username;
        this.password = password;
    }
}
