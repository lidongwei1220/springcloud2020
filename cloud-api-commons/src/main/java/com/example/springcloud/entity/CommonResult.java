package com.example.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 李东薇
 * @date 2020/6/15 14:48
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
