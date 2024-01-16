package com.shuangti.blog.service;

import java.util.ArrayList;
import java.util.Collections;

import com.shuangti.blog.dao.BlogDao;
import com.shuangti.blog.dao.UserDao;
import com.shuangti.blog.entity.Blog;
import com.shuangti.blog.entity.User;

/*
 * Serivce 是 保存数据之前
 * 做一些业务逻辑处理
 */
public class BlogSerivce {

	public boolean createBlog(String tilte, String context, int uid, String uname) {
		BlogDao blogDao = new BlogDao();
		return blogDao.createBlog(tilte, context, uid, uname);

	}

	public ArrayList<Blog> queryMyBlogs(int uid) {
		BlogDao blogDao = new BlogDao();
		ArrayList<Blog> blog = new ArrayList<>();
		blog = blogDao.queryMyBlogs(uid);
		Collections.reverse(blog);
		return blog;
	}

	public ArrayList<Blog> queryAllBlogs() {
		BlogDao blogDao = new BlogDao();
		ArrayList<Blog> blog = new ArrayList<>();
		blog = blogDao.queryAllBlogs();
		Collections.reverse(blog);
		return blog;
	}
	public boolean delMyBlogs(int id) {
		BlogDao blogDao = new BlogDao();
		return blogDao.delBlog(id);
	}
	public Blog getBlog(int id) {
		BlogDao blogDao = new BlogDao();
		return blogDao.getBlog(id);
	}
	public boolean changeBlog(int blogId,String title,String context) {
		BlogDao blogDao = new BlogDao();
		return blogDao.changeBlog(blogId,title,context);
	}
}
