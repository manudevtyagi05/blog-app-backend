package com.blogapp.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
