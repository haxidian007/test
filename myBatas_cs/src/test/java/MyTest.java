import com.jiang.cs.dao.BlogMapper;
import com.jiang.cs.pojo.Blog;
import com.jiang.cs.utils.IDutils;
import com.jiang.cs.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    private BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
    @Test
    public void addInitBlog(){
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        blogMapper.addBlog(blog);
        blog.setId(IDutils.getId());
        blog.setTitle("ava如此简单");
        blogMapper.addBlog(blog);
        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        blogMapper.addBlog(blog);
        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);
        sqlSession.close();
    }
    @Test
    public void queryBlog(){
        HashMap map = new HashMap();
//        map.put("title","ava如此简单");   //通过传递的值不同来实现查询的方式的不同
//        map.put("views",0);
//        List<Blog> blog=blogMapper.queryBlogif(map);
//        List<Blog> blog=blogMapper.queryBlogChoose(map);
        ArrayList ids = new ArrayList<Integer>();
        ids.add(1);
        map.put("ids",ids);
        List<Blog> blog=blogMapper.queryBlogForeach(map);
        for(Blog b:blog){
            System.out.println(b);
        }
    }
    @Test
    public void updateBlog(){
        HashMap map = new HashMap();
        map.put("id","05a835625db1443fbc2313510a921261");
        map.put("title","Java如此简单");
        map.put("author","王者说");
        map.put("createtime",new Date());
        map.put("views",6000);
        int n=blogMapper.updateBlog(map);
        System.out.println(n);
    }
}
