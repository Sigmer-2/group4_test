package com.zlk.group4.report.service;

import com.zlk.group4.report.entity.Report;

import java.util.List;

/**
 * @Interface ReportService
 * @program: group4
 * @description: 举报功能service接口
 * @author: wujian
 * @Date: 2020/9/23 9:10
 **/
public interface ReportService {
    /*
     * @author: wujian
     * @Date: 2020/9/23 9:37
     * @PARAM:[page, limit]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> findAllReport(Integer page, Integer limit);
    /*
     * @author: wujian
     * @Date: 2020/9/23 9:39
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findReportCount();
    Integer updateReport(Integer id);
}
