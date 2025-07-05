package com.lgsoftworks.domain.model;

import com.lgsoftworks.domain.enums.DocumentType;
import com.lgsoftworks.domain.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public abstract class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private Byte age;
    private String cellphone;
    private DocumentType documentType;
    private String documentNumber;
    private String email;
    private String password;
    private String imageUrl;
    private Role role;
}
