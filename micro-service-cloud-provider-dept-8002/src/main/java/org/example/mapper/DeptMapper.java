package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {

    Dept selectByPrimaryKey(Integer deptNo);

    List<Dept> GetAll();
}
