package com.supcon.ses.developer.handler.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 事件
 * <p>
 *    Spring的事件发布订阅模型。可以组件间调用解耦
 * </p>
 * @author lufengdong
 * @create 2023-04-13 13:51
 */
@Getter
@Setter
public class SpringEvent<T> extends ApplicationEvent {

    private T data;

    private String operate;

    public SpringEvent(T data, String operate){
        super(data);
        this.operate = operate;
        this.data = data;
    }
}
