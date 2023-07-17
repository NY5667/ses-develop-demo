package com.supcon.ses.developer.model.dto;

import com.supcon.ses.developer.model.valid.IntValid;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *    测试DTO
 * </p>
 * @author lufengdong
 * @create 2023-07-14 20:08
 */
@Getter
@Setter
public class TestDTO {

    @IntValid(allows = {1,2,3})
    private int test;
}
