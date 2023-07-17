package com.supcon.ses.developer.support.strategy.database;

import com.supcon.ses.developer.support.strategy.IDataBaseStrategy;
import com.supcon.ses.developer.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     SqlServer数据处理类
 * </p>
 * @author lufengdong
 * @create 2022-08-21 15:24
 */
@Slf4j
@Service("sqlserver")
public class SqlServerDataOperator implements IDataBaseStrategy {

    private static final String SQLSERVER_DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    @Override
    public void test() {
        LogUtils.error("SqlServer数据库测试.");
    }
}
