package com.example.postapp.service;


import com.example.postapp.entity.Pkg;
import com.example.postapp.repo.PkgRepo;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PkgService {

    public static final Logger LOG = LoggerFactory.getLogger(PkgService.class);
    private PkgRepo pkgRepo;


    public List<Pkg> findAllPkg() {
        return pkgRepo.findAll();
    }

    public Pkg findOne(Integer id){
        return pkgRepo.findById(id).get();
    }

    public Pkg create(Pkg pkg){

        return  pkgRepo.save(pkg);

    }

    public void delete(Integer id){
        pkgRepo.deleteById(id);
    }

    public Pkg update(Pkg pkg){

        return  pkgRepo.save(pkg);
    }

}
