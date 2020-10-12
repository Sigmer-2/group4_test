package com.zlk.group4.question.controller;

import com.zlk.group4.question.entity.Question;
import com.zlk.group4.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionController
 * @program: group4
 * @description: 问题与咨询控制层
 * @author: wujian
 * @Date: 2020/10/7 9:32
 **/
@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @RequestMapping(value = "/questionMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> questionMessage(Integer page,Integer limit) throws Exception{//查询所有问题与咨询
        Map<String, Object> map = new HashMap<>();
        Integer questionCount = questionService.findQuestionCount();
        List<Question> questionList = questionService.findAllQuestion(page, limit);
        map.put("code",0);
        map.put("data",questionList);
        map.put("count",questionCount);
        return map;
    }
    @RequestMapping(value = "/updateQuestion/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateQuestionById(@PathVariable("id") Integer id)throws Exception{//更新问题与咨询回复状态
        Integer flag = questionService.updateQuestionById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",flag);
        return map;
    }
    @RequestMapping(value = "/selectQuestion",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectQuestionBy(Integer select,String data) throws Exception{//条件查询问题与咨询
        if(select == null){
            select = 0;
        }
        Map<String, Object> map = new HashMap<>();
        if(select == 0){
            List<Question> questionList = questionService.findQuestionByUser(data);
            map.put("code",0);
            map.put("msg","");
            map.put("data",questionList);
        }else if(select == 1){
            List<Question> questionList = questionService.findQuestionByTitle(data);
            map.put("code",0);
            map.put("msg","");
            map.put("data",questionList);
        }
        return map;
    }
}
