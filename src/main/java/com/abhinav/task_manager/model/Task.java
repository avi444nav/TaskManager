package com.abhinav.task_manager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Entity 
@Data

public class Task {
    @Id
  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is mandatory")
    private String title;  
    @Size (max = 500, message = "Description cannot exceed 500 characters") 
    private String description;
    private boolean completed;
     @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore 
    private User user;
}
    

