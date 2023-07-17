package com.supcon.ses.developer.startup;

import com.supcon.ses.developer.support.strategy.context.DataBaseContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>
 *     启动引导类.主要负责关键数据的加载
 * </p>
 *
 * @author lufengdong
 * @create 2023-07-15 20:23
 */
@Component
public class SesStartUpBootStrap implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        //FIXME 如何获取数据库标识逻辑
        String dbType = "sqlserver";
        DataBaseContext.route(dbType);
    }
}
