package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept where dept_no = #{deptNo}")
    /*@Results(id = "map",value = {
            @Result(property = "deptNo", column = "dept_no"),
            @Result(property = "deptName", column = "dept_name"),
            @Result(property = "dbSource", column = "db_source")
    })*/
    Dept selectByPrimaryKey(Integer deptNo);

    @Select("select * from dept")
    //@ResultMap("map")
    List<Dept> GetAll();
}
