package com.supcon.ses.developer.handler.event;

import com.alibaba.fastjson.JSON;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * <p>描述</p>
 *
 * @author lufengdong
 * @create 2023-04-13 13:59
 */
@Component
public class SpringEventListener {

    @Async
    @TransactionalEventListener(classes = SpringEvent.class, condition = "#event.operate.equals('ADD')", phase = TransactionPhase.AFTER_COMMIT)
    public void add(SpringEvent event) {
    }


    @Async
    @TransactionalEventListener(classes = SpringEvent.class, condition = "#event.operate.equals('UPDATE')", phase = TransactionPhase.AFTER_COMMIT)
    public void update(SpringEvent event) {
    }
}
