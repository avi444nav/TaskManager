package com.abhinav.task_manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


@Entity 
@Data 
public class User {
   @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank (message = "Name is mandatory")
    private String name;
    @NotBlank (message = "Email is mandatory")
    @Email (message = "Email should be valid")
    private String email;
    @OneToMany (mappedBy = "user")
    private List<Task> tasks;
}
