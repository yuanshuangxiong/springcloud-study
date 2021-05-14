package com.yuan.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

//所有的实体类序列化
//用1.16.18版本报错，这是个大坑
@Accessors(chain =true) //链式写法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept{

    private Long deptno;
    private String dname;
    private String db_source;

//    public Dept() {
//    }
//
//    public Dept(Long deptno, String dname, String db_source) {
//        this.deptno = deptno;
//        this.dname = dname;
//        this.db_source = db_source;
//    }
//
//    public Long getDeptno() {
//        return deptno;
//    }
//
//    public void setDeptno(Long deptno) {
//        this.deptno = deptno;
//    }
//
//    public String getDname() {
//        return dname;
//    }
//
//    public void setDname(String dname) {
//        this.dname = dname;
//    }
//
//    public String getDb_source() {
//        return db_source;
//    }
//
//    public void setDb_source(String db_source) {
//        this.db_source = db_source;
//    }
//
//        public Dept(String dname){
//        this.dname=dname;
//    }
    /*
    Dept dept= new Dept();
    LL链式写法
    dept.setDeptNo(11).setDname("sss");
     */
}
