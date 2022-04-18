package com.example.postapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*Сущность истории посылки
Добавляет значения при помощи триггеров в Бд
Во время добавлнеия и обновления индекса посылки*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historypkg", indexes = {
        @Index(name = "id_pkg_idx", columnList = "id_pkg"),
        @Index(name = "id_index_idx", columnList = "id_index")
})
@Entity
public class Historypkg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pkg", nullable = false)
    private Pkg idPkg;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_index", nullable = false)
    private PostOffice idIndex;

}