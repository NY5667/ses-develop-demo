package com.supcon.ses.developer.support.strategy.context;

import com.supcon.ses.developer.config.spring.SpringApplicationContext;
import com.supcon.ses.developer.support.strategy.IDataBaseStrategy;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * <p>
 *    数据库上下文
 * </p>
 * @author lufengdong
 * @create 2023-07-15 19:54
 */
@Slf4j
public class DataBaseContext{
    /**
     * 具体使用的数据库策略
     */
    private static IDataBaseStrategy strategy;

    public static void route(String dbType){
        Map<String,  IDataBaseStrategy> strategyMap = SpringApplicationContext.APPLICATION_CONTEXT.getBeansOfType(IDataBaseStrategy.class);
        strategy = strategyMap.getOrDefault(dbType, null);
        if(null == strategy){
            throw new RuntimeException("暂不支持的数据库类型: " + dbType);
        }
    }

    /**
     * 具体的业务
     */
    public static void test(){
        strategy.test();
    }
}
