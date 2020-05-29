package cn.project.mpdemo.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.project.mpdemo.mapper")
public class MyConfig {

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
                return new OptimisticLockerInterceptor();
            }

}
