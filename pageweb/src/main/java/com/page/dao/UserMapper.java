package com.page.dao;

import com.page.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //方法存在多个参数，所有的参数前面必须加上@param("名字")注解
//    @Select("select * from pagetab")
    List<User> getUserList(Map map);
    List<User> getUserListAll(Map map);
//    List<User> nextpage(Map map);
}
