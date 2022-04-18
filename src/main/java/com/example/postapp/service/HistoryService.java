package com.example.postapp.service;

import com.example.postapp.entity.Historypkg;
import com.example.postapp.repo.HistoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional
public class HistoryService {

    private HistoryRepo historyRepo;

    public List<Object>findWay(Integer id){
        return historyRepo.findAllByIdPkg(id);
    }

    public void deleteHis(Integer id){
        historyRepo.deleteByIdPkg(id);
    }

}
