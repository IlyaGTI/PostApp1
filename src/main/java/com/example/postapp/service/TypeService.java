package com.example.postapp.service;

import com.example.postapp.dto.PostOfficeDTO;
import com.example.postapp.dto.TypePostDTO;
import com.example.postapp.entity.PostOffice;
import com.example.postapp.entity.TypePost;
import com.example.postapp.repo.TypeRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class TypeService {

    private TypeRepo typeRepo;

    private ModelMapper modelMapper;

    public TypePost findOne(Integer id){
        return (TypePost) typeRepo.findById(id).get();
    }

    public TypePostDTO convertToTypePostDTO(TypePost typePost){
        TypePostDTO typePostDTO = modelMapper.map(typePost, TypePostDTO.class);
        return typePostDTO;
    }
}
