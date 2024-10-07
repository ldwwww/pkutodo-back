package edu.pku.pkutodobackend.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author：liudawei
 * @Description:数据返回格式规范
 * @DateTime:2024/10/6 19:35
 **/
public class DataVO<T> {

    @Getter @Setter
    private Integer code;   // 状态码
    @Getter @Setter
    private String msg;     // 提示信息
    @Getter @Setter
    private T data;       // 具体数据

    public DataVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public DataVO(){};


}
