package com.blogapp.payload;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

    private Date addedDate;

    private Integer userId;

    private Integer categoryId;

}
