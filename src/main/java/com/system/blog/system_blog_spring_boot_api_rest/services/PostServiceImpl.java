package com.system.blog.system_blog_spring_boot_api_rest.services;

import com.system.blog.system_blog_spring_boot_api_rest.dto.PostDTO;
import com.system.blog.system_blog_spring_boot_api_rest.entity.Post;
import com.system.blog.system_blog_spring_boot_api_rest.repository.RepositoryPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private RepositoryPost repositoryPost;

    @Override

    public PostDTO createPost(PostDTO postDTO) {
        //Converting from DTO (Data transfer Object) to Entity
        Post post = new Post();

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setName(postDTO.getName()); // <-- Faltaba asignar name aquí


        Post newPost = repositoryPost.save(post);

        //Converting from Entity to DTO
        PostDTO postResponse = new PostDTO();

        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setContent(newPost.getContent());
        postResponse.setDescription(newPost.getDescription());
        postResponse.setName(newPost.getName());

        return postResponse;
    }
}
