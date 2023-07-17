package com.supcon.ses.developer.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *     日志工具类
 * </p>
 * @author lufengdong
 * @create 2023-07-14 16:22
 */
@Slf4j
public class LogUtils {

    public static void error(String format, String...messages){
        log.error(format, messages);
    }
}
