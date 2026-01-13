package com.project.fitness.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User{
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
     private String  id;

     private String email;
     private String password;
     private String firstName;
     private String lastName;
     @CreationTimestamp
     private LocalDateTime createAt;
     @UpdateTimestamp
     private LocalDateTime updateAt;

     @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonIgnore
     private List<Activity> activities=new ArrayList<>();

    @OneToMany(mappedBy ="user",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Recommendation> recommendations=new ArrayList<>()  ;


//    public <E> User(Object o, String email, String password, String firstName, String lastName, LocalDateTime createAt, List<E> of, List<E> of1, LocalDateTime updateAt, List<E> of2, List<E> of3) {
//    }
}
