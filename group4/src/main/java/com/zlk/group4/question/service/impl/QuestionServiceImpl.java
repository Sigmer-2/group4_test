package com.zlk.group4.question.service.impl;

import com.zlk.group4.question.entity.Question;
import com.zlk.group4.question.mapper.QuestionMapper;
import com.zlk.group4.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionServiceImpl
 * @program: group4
 * @description: 问题与咨询service实现类
 * @author: wujian
 * @Date: 2020/10/7 10:21
 **/
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<Question> findAllQuestion(Integer page, Integer limit) {
       Map<String, Object> map = new HashMap<>();
       Integer startIndex = (page-1)*limit;
       map.put("startIndex",startIndex);
       map.put("limit",limit);
       return questionMapper.findAllQuestion(map);
    }

    @Override
    public Integer findQuestionCount() {
        return questionMapper.findQuestionCount();
    }

    @Override
    public Integer updateQuestionById(Integer id) {
        return questionMapper.updateQuestionById(id);
    }

    @Override
    public List<Question> findQuestionByUser(String data) {
        return questionMapper.findQuestionByUser(data);
    }

    @Override
    public List<Question> findQuestionByTitle(String data) {
        return questionMapper.findQuestionByTitle(data);
    }

    @Override
    public Integer saveQuestion(Question question) {
        return questionMapper.saveQuestion(question);
    }
}
