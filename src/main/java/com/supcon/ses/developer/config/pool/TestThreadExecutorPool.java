package com.supcon.ses.developer.config.pool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     这是一个测试的线程池
 * </p>
 * @author lufengdong
 * @create 2023-07-14 15:36
 */
@Component
@ConfigurationProperties(prefix = "async-pool.test")
public class TestThreadExecutorPool extends AbstractThreadExecutorPool{

    @Override
    String getThreadPrefix() {
        return "TEST_THREAD_";
    }
}
