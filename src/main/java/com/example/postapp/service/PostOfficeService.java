package com.example.postapp.service;

import com.example.postapp.entity.PostOffice;
import com.example.postapp.repo.PostOfficeRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PostOfficeService {
    @Autowired
    private PostOfficeRepo postOfficeRepo;
    private ModelMapper modelMapper;

    public PostOffice addOffice(PostOffice postOffice){
        return postOfficeRepo.save(postOffice);
    }

    public List<PostOffice> findAllOffice() {
        return postOfficeRepo.findAll();
    }

    public PostOffice findOfficeById(Integer id) {
        return postOfficeRepo.findById(id).get();
    }

    public PostOffice updateOffice(PostOffice postOffice) {
        return postOfficeRepo.save(postOffice);
    }

    public void deleteById(Integer id){
        postOfficeRepo.deleteById(id);
    }



}
