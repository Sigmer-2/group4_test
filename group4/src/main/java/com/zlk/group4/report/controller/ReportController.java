package com.zlk.group4.report.controller;

import com.zlk.group4.report.entity.Report;
import com.zlk.group4.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping("/reportMessage")
    @ResponseBody
    public Map<String, Object> reportMessage(Integer page, Integer limit) throws Exception {
        List<Report> reportList = reportService.findAllReport(page, limit);
        Integer reportCount = reportService.findReportCount();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("data", reportList);
        map.put("count", reportCount);
        return map;
    }
    @RequestMapping("/updateReportById/{id}")
    @ResponseBody
    public Map<String,Object> updateReport(@PathVariable("id") Integer id){
        Integer flag = reportService.updateReport(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status",flag);
        return map;
    }
}
