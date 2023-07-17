package com.supcon.ses.developer.controller;

import com.supcon.ses.developer.model.BaseResponse;
import com.supcon.ses.developer.model.dto.TestDTO;
import com.supcon.ses.developer.support.strategy.context.DataBaseContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *     测试接口
 * </p>
 *
 * @author lufengdong
 * @create 2023-07-14 20:08
 */
@RestController
@RequestMapping("/")
public class TestController {

    @PostMapping("/valid")
    public BaseResponse<String> test(@Valid TestDTO testDTO){
        return BaseResponse.success("操作成功");
    }

    @PostMapping("/database")
    public BaseResponse<String> database(){
        DataBaseContext.test();
        return BaseResponse.success("操作成功");
    }
}
