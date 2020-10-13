package com.zlk.group4.question.service;

import com.zlk.group4.question.entity.Question;

import java.util.List;


/**
 * @ClassName QuestionService
 * @program: group4
 * @description: 问题与咨询service层
 * @author: wujian
 * @Date: 2020/10/7 10:17
 **/
public interface QuestionService {
    /**
     *查询所有问题与咨询
     * @author: wujian
     * @Date: 2020/10/7 10:54
     * @PARAM:[page, limit]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findAllQuestion(Integer page,Integer limit);
    /**
     *查询问题与咨询数量
     * @author: wujian
     * @Date: 2020/10/7 10:55
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findQuestionCount();
    /**
     *更新回复状态
     * @author: wujian
     * @Date: 2020/10/7 10:55
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateQuestionById(Integer id);
    /**
     *根据用户查询
     * @author: wujian
     * @Date: 2020/10/7 10:55
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findQuestionByUser(String data);
    /**
     *根据标题查询
     * @author: wujian
     * @Date: 2020/10/7 10:55
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findQuestionByTitle(String data);
    Integer saveQuestion(Question question);
}
