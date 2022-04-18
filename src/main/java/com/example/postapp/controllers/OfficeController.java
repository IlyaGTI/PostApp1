package com.example.postapp.controllers;

import com.example.postapp.entity.PostOffice;
import com.example.postapp.service.PostOfficeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/office")
@AllArgsConstructor
public class OfficeController {

    private PostOfficeService postOfficeService;

    @PostMapping("/create")
    public ResponseEntity<PostOffice> createPkg(@RequestBody PostOffice postOffice) {
        return ResponseEntity.ok(postOfficeService.addOffice(postOffice));
    }

    @PatchMapping("/update")
    public ResponseEntity updateOf(@RequestBody PostOffice postOffice) {

        return ResponseEntity.ok(postOfficeService.updateOffice(postOffice));

    }



}
