package com.zlk.group4.question.mapper;

import com.zlk.group4.question.entity.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionMapper
 * @program: group4
 * @description: 问题与咨询mapper层
 * @author: wujian
 * @Date: 2020/10/7 9:47
 **/
@Mapper
public interface QuestionMapper {
    /**
     *查询所有信息
     * @author: wujian
     * @Date: 2020/10/7 10:57
     * @PARAM:[map]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findAllQuestion(Map map);
    /**
     *查询数量
     * @author: wujian
     * @Date: 2020/10/7 10:57
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findQuestionCount();
    /**
     *更新回复状态
     * @author: wujian
     * @Date: 2020/10/7 10:58
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateQuestionById(Integer id);
    /**
     *根据用户查询
     * @author: wujian
     * @Date: 2020/10/7 10:58
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findQuestionByUser(String data);
    /**
     *根据标体查询
     * @author: wujian
     * @Date: 2020/10/7 10:58
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.question.entity.Question>
     */
    List<Question> findQuestionByTitle(String data);
    Integer saveQuestion(Question question);
}
