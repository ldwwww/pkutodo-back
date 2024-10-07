package edu.pku.pkutodobackend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：liudawei
 * @Description:扫描Mapper接口路径
 * @DateTime:2024/10/5 13:15
 **/

@Configuration
@MapperScan({"edu.pku.pkutodobackend.mapper","edu.pku.pkutodobackend.dao"})
public class MybatisConfig {
}
