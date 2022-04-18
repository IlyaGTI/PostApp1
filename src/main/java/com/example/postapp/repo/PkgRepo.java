package com.example.postapp.repo;

import com.example.postapp.entity.Pkg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PkgRepo extends JpaRepository<Pkg, Integer> {

    //@Query("select p.id, p.idIndOrd.ind, p.idType.nameType, p.adress, p.nameOrder  " +
      //      "from Pkg as p where p.id=:p_id")
    //Optional<Object> findById(@Param("p_id") Integer id);

    Optional<Pkg> findById(Integer id);



}
