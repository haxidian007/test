package com.jiang.cs.dao;

import com.jiang.cs.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);
    int updateBlog(Map map);
    List<Blog> queryBlogif(Map map);
    List<Blog> queryBlogChoose(Map map);
    List<Blog> queryBlogForeach(Map ids);
}
