package com.example.postapp.repo;

import com.example.postapp.entity.TypePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepo extends JpaRepository<TypePost, Integer> {
    Optional<TypePost> findById(Integer id);
}
