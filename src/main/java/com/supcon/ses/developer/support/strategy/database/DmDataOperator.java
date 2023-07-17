package com.supcon.ses.developer.support.strategy.database;

import com.supcon.ses.developer.support.strategy.IDataBaseStrategy;
import com.supcon.ses.developer.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     达梦数据处理类
 * </p>
 *
 * @author lufengdong
 * @create 2023-07-15 19:53
 */
@Slf4j
@Service("dm")
public class DmDataOperator implements IDataBaseStrategy {
    @Override
    public void test() {
        LogUtils.error("达梦数据库测试.");
    }
}
