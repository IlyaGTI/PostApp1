package com.example.postapp.repo;

import com.example.postapp.entity.Historypkg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HistoryRepo extends JpaRepository<Historypkg, Integer> {
    @Query("SELECT hs.idIndex.ind, hs.idIndex.adressbranch FROM Historypkg as hs where hs.idPkg.id =:idPkg")
    List<Object> findAllByIdPkg(@Param("idPkg") Integer id);
    @Query("delete from Historypkg as hs where hs.idPkg.id =:idPkg")
    void deleteByIdPkg(@Param("idPkg") Integer id);
}
