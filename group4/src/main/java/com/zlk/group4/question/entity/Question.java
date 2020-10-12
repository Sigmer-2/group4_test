package com.zlk.group4.question.entity;

import com.zlk.group4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Question
 * @program: group4
 * @description: 问题与咨询实体类
 * @author: wujian
 * @Date: 2020/10/7 9:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    /**问题id*/
    private  Integer id;
    /**提问用户id*/
    private Integer questionUserId;
    /**问题标题*/
    private String questionTitle;
    /**问题描述*/
    private String questionDescribe;
    /**提问用户电话*/
    private String questionPhone;
    /**问题状态*/
    private Integer questionStatus;
    /**用户对象*/
    private User user;
}
