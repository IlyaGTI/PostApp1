package com.example.postapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post_office")
@Entity
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ind", nullable = false)
    private Integer ind;

    @Column(name = "name_branch", nullable = false, length = 45)
    private String nameBranch;

    @Column(name = "adressbranch", nullable = false, length = 45)
    private String adressbranch;

}