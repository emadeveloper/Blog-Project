package com.system.blog.system_blog_spring_boot_api_rest.repository;

import com.system.blog.system_blog_spring_boot_api_rest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPost extends JpaRepository<Post, Long> {

}
