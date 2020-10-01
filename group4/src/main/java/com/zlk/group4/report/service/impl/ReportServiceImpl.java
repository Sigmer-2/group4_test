package com.zlk.group4.report.service.impl;

import com.zlk.group4.report.entity.Report;
import com.zlk.group4.report.mapper.ReportMapper;
import com.zlk.group4.report.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportServiceImpl
 * @program: group4
 * @description: 举报工能service接口实现类
 * @author: wujian
 * @Date: 2020/9/23 9:13
 **/
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
    @Override
    public List<Report> findAllReport(Integer page, Integer limit) {
        Map<String, Object> paraMap = new HashMap<>();
        Integer startIndex = (page-1)*limit;
        paraMap.put("startIndex",startIndex);
        paraMap.put("pageSize",limit);
        return reportMapper.findAllReport(paraMap);
    }

    @Override
    public Integer findReportCount() {
        return reportMapper.findReportCount();
    }

    @Override
    public Integer updateReport(Integer id) {
        return reportMapper.updateReport(id);
    }

    @Override
    public List<Report> selectReportByUser(String data) {
        return reportMapper.selectReportByUser(data);
    }

    @Override
    public List<Report> selectReportByHouse(String data) {
        return reportMapper.selectReportByHouse(data);
    }

}
