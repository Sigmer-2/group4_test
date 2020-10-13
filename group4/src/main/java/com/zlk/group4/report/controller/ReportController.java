package com.zlk.group4.report.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.report.entity.Report;
import com.zlk.group4.report.service.ReportService;
import com.zlk.group4.util.MyHouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportController
 * @program: group4
 * @description: 举报
 * @author: wujian
 * @Date: 2020/9/22 17:01
 **/
@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @RequestMapping(value = "/reportMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> reportMessage(Integer page, Integer limit) throws Exception {//查询所有举报记录
        List<Report> reportList = reportService.findAllReport(page, limit);
        Integer reportCount = reportService.findReportCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", reportList);
        map.put("count", reportCount);
        return map;
    }
    @RequestMapping(value = "/updateReportById/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateReport(@PathVariable("id") Integer id){//更新举报审核状态
        Integer flag = reportService.updateReport(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status",flag);
        return map;
    }
    @RequestMapping(value = "/selectReportBy",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectReportBy(Integer select,String data) throws Exception {//条件查询举报记录
        if (select == null) {
            select = 0;
        }
        Map<String, Object> map = new HashMap<>();
        if (select == 0) {
            List<Report> reportList = reportService.selectReportByUser(data);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", reportList);
        } else if (select == 1) {
            List<Report> reportList = reportService.selectReportByHouse(data);
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", reportList);
        }
        return map;
    }

    @PostMapping(value = "/saveReport",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> saveReport(HttpServletRequest request, HttpServletResponse response){
        //未完成
        Map<String, Object> map = new HashMap<>();
        System.out.println("小程序调用");
        JSONObject result = MyHouseUtils.getResult(request);
        String userId = result.getString("userId");
        String houseId = result.getString("houseId");
        if ("".equals(userId)&&"".equals(houseId)){
            map.put("msg","请登录");
        }else {
            String reportReason = result.getString("reportReason");
            String reportDetails = result.getString("reportDetails");
            Report report = new Report();
            report.setReportUserId(Integer.parseInt(userId));
            report.setReportHouseId(Integer.parseInt(houseId));
            report.setReportReason(reportReason);
            report.setReportDetails(reportDetails);
            report.setReportStatus(0);
            int i = reportService.insertReport(report);
            if (i>0){
                map.put("code",0);
            }else {
                map.put("code",500);
            }
        }
        return map;
    }
}
