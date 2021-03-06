package com.zlk.group4.report.mapper;

import com.zlk.group4.report.entity.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ReportMapper
 * @program: group4
 * @description: 举报mapper接口
 * @author: wujian
 * @Date: 2020/9/22 17:16
 **/
@Mapper
public interface ReportMapper {
    /**
     * 查询所有举报记录
     * @author: wujian
     * @Date: 2020/10/1 15:09
     * @PARAM:[map]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> findAllReport(Map map);

    /**
     * 查询举报数量
     * @author: wujian
     * @Date: 2020/10/1 15:09
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findReportCount();

    /**
     * 更新举报审核状态
     * @author: wujian
     * @Date: 2020/10/1 15:09
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateReport(Integer id);

    /**
     * 根据用户查询举报记录
     * @author: wujian
     * @Date: 2020/10/1 15:09
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> selectReportByUser(String data);

    /**
     * 根据房屋查询举报记录
     * @author: wujian
     * @Date: 2020/10/1 15:09
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.report.entity.Report>
     */
    List<Report> selectReportByHouse(String data);
    /**
     * 增加举报房源记录
     * @Auther sunshuai
     * @Date 2020/10/13 14:29
     * @param report
     * @return int
     */
    int insertReport(Report report);
}
