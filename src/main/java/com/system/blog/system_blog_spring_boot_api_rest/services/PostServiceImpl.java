package com.system.blog.system_blog_spring_boot_api_rest.services;

import com.system.blog.system_blog_spring_boot_api_rest.dto.PostDTO;
import com.system.blog.system_blog_spring_boot_api_rest.entity.Post;
import com.system.blog.system_blog_spring_boot_api_rest.exceptions.ResourceNotFoundException;
import com.system.blog.system_blog_spring_boot_api_rest.repository.RepositoryPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private RepositoryPost repositoryPost;

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        //Converting from DTO (Data transfer Object) to Entity
        Post post = mapEntity(postDTO);

        Post newPost = repositoryPost.save(post);

        // Directly returning the mapped DTO
        return mapDTO(newPost);
    }

    //Get all posts
    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = repositoryPost.findAll();
        return posts.stream()
                .map(this::mapDTO)
                .collect(Collectors.toList());
    }

    //Get Post by ID
    @Override
    public PostDTO getPostById(long id) {
        Post post = repositoryPost
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        return mapDTO(post);
    }

    // Method to convert Entity to DTO
    private PostDTO mapDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setDescription(post.getDescription());
        postDTO.setName(post.getName());

        return postDTO;
    }

    // Method to convert DTO to Entity
    private Post mapEntity(PostDTO postDTO) {
        Post post = new Post();

        post.setName(postDTO.getName());
        post.setId(postDTO.getId());
        post.setContent(postDTO.getContent());
        post.setDescription(postDTO.getDescription());
        post.setTitle(postDTO.getTitle());

        return post;
    }

}
