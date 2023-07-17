package com.supcon.ses.developer.support.strategy.database;

import com.supcon.ses.developer.support.strategy.IDataBaseStrategy;
import com.supcon.ses.developer.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     MySql数据处理类
 * </p>
 * @author lufengdong
 * @create 2022-08-21 15:26
 */
@Slf4j
@Service("mysql")
public class MySqlDataOperator implements IDataBaseStrategy {
    /**
     * MYSQL驱动名称
     */
    private static final String MYSQL_DRIVER_NAME = "com.mysql.jdbc.Driver";

    @Override
    public void test() {
        LogUtils.error("MySql数据库测试.");
    }
}
