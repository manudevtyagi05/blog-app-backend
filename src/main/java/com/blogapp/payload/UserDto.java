package com.blogapp.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;
    private String name;       // 👈 Make sure this field is here
    private String email;
    private String password;
    private String about;

}
