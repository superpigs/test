package com.zhulei.test.dao;

import com.zhulei.test.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersDao {
    @Select({"select * from users where uname = #{uname} and upwd = #{upwd}"})
    public Users findByUnameAndUpwd(@Param("uname") String uname,
                                    @Param("upwd") String upwd);

    @Insert({"insert into users (uname, upwd, realname, token, sex) " +
            "values (#{uname}, #{upwd}, #{realname}, #{token}, #{sex})"})
    public int add(Users users);

    @Update({"update users set token = #{token} where uid = #{uid}"})
    public int updateToken(@Param("uid") int uid, @Param("token") String token);
}
