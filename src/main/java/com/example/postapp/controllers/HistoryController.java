package com.example.postapp.controllers;


import com.example.postapp.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;

    /*Вывод истории посылки*/
    @GetMapping("/find/{id}")
    ResponseEntity<List<Object>> history(@PathVariable Integer id){
        return ResponseEntity.ok(historyService.findWay(id));
    }
}
