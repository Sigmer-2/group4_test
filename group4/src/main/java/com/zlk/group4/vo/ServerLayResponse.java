package com.zlk.group4.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: 封装后端数据返回给layui的数据
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 10:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ServerLayResponse<T> {
    private Integer code;
    private Integer count;
    private String msg;
    private T data;
}
