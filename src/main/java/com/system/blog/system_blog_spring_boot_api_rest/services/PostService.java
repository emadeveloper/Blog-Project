package com.system.blog.system_blog_spring_boot_api_rest.services;

import com.system.blog.system_blog_spring_boot_api_rest.dto.PostDTO;

import java.util.List;

public interface PostService {

    public PostDTO createPost(PostDTO postDTO);

    public List<PostDTO> getAllPosts();

    public PostDTO getPostById(long id);

    public PostDTO updatePost (PostDTO postDTO, long id);
}
