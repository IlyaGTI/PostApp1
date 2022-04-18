package com.example.postapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pkg", indexes = {
        @Index(name = "id_idx", columnList = "id_type"),
        @Index(name = "id_ind_ord_idx", columnList = "id_ind_ord"),
        @Index(name = "id_index_idx", columnList = "id_index")
})
@Entity
public class Pkg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_type", nullable = false)
    private TypePost idType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_index", nullable = false)
    private PostOffice idIndex;

    @Column(name = "adress", nullable = false, length = 250)
    private String adress;

    @Column(name = "name_order", nullable = false, length = 45)
    private String nameOrder;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ind_ord", nullable = false)
    private PostOffice idIndOrd;

}