package com.system.blog.system_blog_spring_boot_api_rest.services;

import com.system.blog.system_blog_spring_boot_api_rest.dto.PostDTO;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);
}
