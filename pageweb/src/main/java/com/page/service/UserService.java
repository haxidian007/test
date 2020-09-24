package com.page.service;

import com.page.dao.UserMapper;
import com.page.pojo.User;
import com.page.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

    public List<User> prevp(String query,int count,int pagination){
        System.out.println(4);
        Map<String,Object> map=new HashMap();
        map.put("query",query);
        map.put("count",count);
        int pag=count+pagination;
        map.put("pagination",pag);
        List<User> nextpage = userMapper.getUserList(map);
        return nextpage;
    }
    /**
     * 返回下一页的记录条数
     * @param query 查询条件
     * @param count 起始值
     * @param pagination 显示页数
     * @return 返回User类型的集合
     */
    public List<User>  nextp(String query,int count,int pagination){
        System.out.println(4);
        Map<String,Object> map=new HashMap();
        map.put("query",query);
        map.put("count",count);
        int pag=count+pagination;
        map.put("pagination",pag);
        List<User> nextpage = userMapper.getUserList(map);
        return nextpage;
    }

    /**
     * 以密码查询
     * @param query 查询条件
     * @param pagination 显示条数
     * @return 返回User类型的集合
     */
    public List<User>  queryp(String query,int count,int pagination){
        System.out.println("第三");
        Map<String,Object> map=new HashMap();
        map.put("query",query);
        map.put("count",count);
        map.put("pagination",pagination);
        List<User> userList = userMapper.getUserList(map);
//        sqlSession.close();
        return userList;
    }

    /**
     * 查询数据库pagetab表的全部记录
     * @return 返回User类型的集合
     */
    public List<User> queryallp(int count,int pagination){
        System.out.println(4);
        Map map =new HashMap();
        map.put("count",count);
        map.put("pagination",pagination);
        List<User> userlistall = userMapper.getUserListAll(map);
//        sqlSession.close();
        return userlistall;
    }
}
