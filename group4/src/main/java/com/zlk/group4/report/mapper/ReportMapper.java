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
    List<Report> findAllReport(Map map);
    Integer findReportCount();
    Integer updateReport(Integer id);
}
