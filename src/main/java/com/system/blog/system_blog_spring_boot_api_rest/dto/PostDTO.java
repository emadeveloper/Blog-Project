package com.system.blog.system_blog_spring_boot_api_rest.dto;

import lombok.*;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String content;
}
