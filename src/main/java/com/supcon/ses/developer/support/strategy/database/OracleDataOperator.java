package com.supcon.ses.developer.support.strategy.database;

import com.supcon.ses.developer.support.strategy.IDataBaseStrategy;
import com.supcon.ses.developer.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     Oracle数据处理类
 * </p>
 * @author lufengdong
 * @create 2022-08-21 15:26
 */
@Slf4j
@Service("oracle")
public class OracleDataOperator implements IDataBaseStrategy {
    /**
     * ORACLE的驱动名称
     */
    private static final String ORACLE_DRIVER_NAME = "oracle.jdbc.OracleDriver";

    @Override
    public void test() {
        LogUtils.error("Oracle数据库测试.");
    }
}
