package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Kersinal
 */
@NoArgsConstructor //无参构造函数
@Data // 提供类的get、set、equals、hashCode、canEqual、toString 方法
@Accessors(chain = true) //链式编程
public class Dept {
    private Integer deptNo;
    private String deptName;
    private String dbSource;
}
