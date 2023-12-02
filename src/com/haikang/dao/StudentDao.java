package com.haikang.dao;

import com.haikang.entity.Student;
import com.haikang.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    //增加
    public int addStudent(Student student){
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = " insert into student(id,sName,sNo,age) " + " values(?,?,?,?) ";
        int ret = 0;
        conn = DBUtils.getConn();
        try {
            statement = conn.prepareStatement(sql); //执行第一次
            statement.setInt(1,student.getId());
            statement.setString(2,student.getsName());
            statement.setString(3,student.getsNo());
            statement.setInt(4,student.getAge());

            ret = statement.executeUpdate(); //执行第二次
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(conn,statement,null);
        }
        return ret;
    }

    //删除(针对主键)
    public int delStudent(int id){
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = " delete from student where id = ? ";
        int ret = 0;
        conn = DBUtils.getConn();
        try {
            statement = conn.prepareStatement(sql); //执行第一次
            statement.setInt(1,id);
            
            ret = statement.executeUpdate(); //执行第二次
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(conn,statement,null);
        }
        return ret;
    }

    //修改
    public int updateStudent(Student student){
        Connection conn = null;
        PreparedStatement statement = null;
        String sql = " update student set sNo=?,sName=?,age=? where id=? ";
        int ret = 0;
        conn = DBUtils.getConn();
        try {
            statement = conn.prepareStatement(sql); //执行第一次
            statement.setInt(4,student.getId());
            statement.setString(2,student.getsName());
            statement.setString(1,student.getsNo());
            statement.setInt(3,student.getAge());

            ret = statement.executeUpdate(); //执行第二次
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.closeAll(conn,statement,null);
        }
        return ret;
    }

    //查询所有
    public List<Student> getAll(){
        List<Student> studentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String sql = " select * from student ";

        conn = DBUtils.getConn();
        try {
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                //每循环一次，封装一个student对象
                Student stu = new Student();
                stu.setsNo(rs.getString("sNo"));
                stu.setAge(rs.getInt("age"));
                stu.setsName(rs.getString("sName"));
                stu.setId(rs.getInt("id"));

                //每循环一次，把student装载到容器里
                studentList.add(stu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtils.closeAll(conn,preparedStatement,rs);
        }
        return studentList;
    }


    //查询单个
    public Student getStuById(int id){
        Student student = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        String sql = " select * from student where id=? ";
        conn = DBUtils.getConn();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeQuery();
            if (rs.next()){
                student = new Student();
                student.setsNo(rs.getString("sNo"));
                student.setId(rs.getInt("id"));
                student.setsName(rs.getString("sName"));
                student.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtils.closeAll(conn,preparedStatement,rs);
        }
        return student;

    };

}
