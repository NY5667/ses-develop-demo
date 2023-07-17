package com.supcon.ses.developer.config.pool;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 *    线程池
 * </p>
 * @author lufengdong
 * @create 2023-07-14 15:29
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractThreadExecutorPool {
    /**
     *  核心线程数
     */
    private int corePoolSize;
    /**
     *  最大线程数
     */
    private int maxPoolSize;
    /**
     *  非核心线程数生存周期
     */
    private int keepAliveSeconds;
    /**
     *  队列容量
     */
    private int queueCapacity;
    /**
     * 返回线程的前缀
     * @return
     */
    abstract String getThreadPrefix();
}
