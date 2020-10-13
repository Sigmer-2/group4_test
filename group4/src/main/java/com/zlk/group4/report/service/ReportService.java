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
    /**
     * 查询所有举报记录
     * @author: wujian
     * @Date: 2020/9/23 9:37
     * @PARAM:[page, limit]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> findAllReport(Integer page, Integer limit);

    /**
     * 查询举报数量
     * @author: wujian
     * @Date: 2020/9/23 9:39
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findReportCount();
    /**
     *更新举报审核状态
     * @author: wujian
     * @Date: 2020/10/1 15:12
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateReport(Integer id);
    /**
     *根据用户查询举报记录
     * @author: wujian
     * @Date: 2020/10/1 15:12
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> selectReportByUser(String data);
    /**
     *根据房屋查询举报记录
     * @author: wujian
     * @Date: 2020/10/1 15:12
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> selectReportByHouse(String data);
    /**
     * 新增房屋举报详情返回受影响行数
     * @Auther sunshuai
     * @Date 2020/10/13 14:32
     * @param report
     * @return int
     */
    int insertReport(Report report);
}
