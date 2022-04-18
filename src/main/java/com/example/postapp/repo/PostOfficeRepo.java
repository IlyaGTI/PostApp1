package com.example.postapp.repo;

import com.example.postapp.entity.PostOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostOfficeRepo extends JpaRepository<PostOffice, Integer> {
    Optional<PostOffice> findById(Integer id);
}
