package com.ljj.crawler.admin.extract.dao;

import com.ljj.crawler.admin.extract.po.TaskInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

/**
 * 功能：
 *
 * @Author:JIUNLIU
 * @data : 2020/7/12 13:31
 */
@Mapper
public interface TaskInfoMapper {

    @Select("SELECT id,name,start_url,have_rule,status FROM url_config WHERE id = #{id}")
    @Result(column = "start_url", property = "startUrl")
    @Result(column = "have_rule", property = "haveRule")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    TaskInfo findById(Integer id);
}