package com.haikang;

import com.haikang.dao.StudentDao;
import com.haikang.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

//com.mysql.cj.jdbc.Driver
public class Jdbc {
    public static void main(String[] args) throws Exception{

    }

    //增加
    public void testAdd(){
        StudentDao dao = new StudentDao();
        Student student = new Student();
        student.setId(3);
        student.setsName("haha");
        student.setsNo("003");
        student.setAge(5);
        int i = dao.addStudent(student);
        System.out.println(i);
    }

    //删除
    public void testDel(){
        StudentDao dao = new StudentDao();
        System.out.println(dao.delStudent(2));
    }

    //修改
    public void testUpdate(){
        StudentDao dao = new StudentDao();
        Student student = new Student();
        student.setId(3);
        student.setsName("大神");
        student.setsNo("888");
        student.setAge(20);
        int i = dao.updateStudent(student);
        System.out.println(i);
    }

    //查询所有
    public void testSearchAll(){
        StudentDao dao = new StudentDao();
        List<Student> studentList = dao.getAll();
        studentList.forEach((e)->{
            System.out.println(e);
        });
    }

    //查询单个
    public void testSearch(){
        StudentDao dao = new StudentDao();
        Student student = dao.getStuById(1);
        System.out.println(student);
    }


    public void testSql() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver"); //类加载器，加载驱动类

        String url = "jdbc:mysql://127.0.0.1:3306/zemyld";
        String userName = "root";
        String password = "zlr15908209105";

        Connection conn = DriverManager.getConnection(url,userName,password);//驱动类获取连接,是java.sql的链接

        Statement stmt = conn.createStatement(); //处理器直接访问（一次）

        String sql = " select * from student ";
        ResultSet rs = stmt.executeQuery(sql); //返回结果集;直接执行sql

        while (rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("sName"));
            System.out.println(rs.getString("sNo"));
            System.out.println(rs.getInt("age"));
        }

        if (rs != null ){
            rs.close();
        }
        stmt.close();
        conn.close();
        System.out.println(conn);
    }

}
