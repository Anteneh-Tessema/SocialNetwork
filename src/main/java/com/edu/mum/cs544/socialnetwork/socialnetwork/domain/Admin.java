package com.edu.mum.cs544.socialnetwork.socialnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
     private String email;
    @Column(name = "password")
     private String password;
    @Column(name = "delete")
    private boolean deleted;
    //@Column(name = "date")
   // private LocalDateTime recordedDate;

    public Admin() {
        id = UUID.randomUUID().toString();
        this.deleted = Boolean.FALSE;
        //this.recordedDate = LocalDateTime.now();
    }
    public boolean isDeleted() {
        return deleted;
    }
}

