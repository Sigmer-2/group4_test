package com.zlk.group4.question.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.question.entity.Question;
import com.zlk.group4.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
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
    @RequestMapping(value = "/saveQuestion",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> saveQuestion(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Map<String, Object> map = new HashMap<>();
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String questionTitle = result.getString("questionTitle");
        String questionDescribe = result.getString("questionDescribe");
        String phone = result.getString("phone");
        Integer userId = result.getInteger("userId");
        System.out.println(questionTitle+","+questionDescribe+","+phone+","+userId);
        Question question = new Question();
        question.setQuestionUserId(userId);
        question.setQuestionTitle(questionTitle);
        question.setQuestionDescribe(questionDescribe);
        question.setQuestionPhone(phone);
        Integer flag = questionService.saveQuestion(question);
        map.put("status",flag);
        return map;
    }
}
