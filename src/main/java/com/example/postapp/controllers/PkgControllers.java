package com.example.postapp.controllers;

import com.example.postapp.controllers.Pojo.MsgRes;
import com.example.postapp.entity.Pkg;
import com.example.postapp.service.HistoryService;
import com.example.postapp.service.PkgService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
/*//Контороллер для управления посылками*/
@AllArgsConstructor
@RestController
@RequestMapping("/pkg")
public class PkgControllers {

    PkgService pkgService;
    HistoryService historyService;

    /*Вывод всех посылок*/
    @GetMapping("/all")
    public ResponseEntity<List<Pkg>> allPkg() {
        return ResponseEntity.ok(pkgService.findAllPkg());
    }

    /*Вывод статуса посылки*/
    @GetMapping("/status/{id}")
    public ResponseEntity status(@PathVariable Integer id) {
        Pkg status = pkgService.findOne(id);

        if (status.getIdIndex().getId().equals(status.getIdIndOrd().getId())) {
            return ResponseEntity.ok(new MsgRes("Посылка в пункте выдачи"));
        } else if (!status.getIdIndex().getId().equals(status.getIdIndOrd().getId())) {
            return ResponseEntity.ok(new MsgRes("Посылка ушла из промежуточного отделения"));
        } else {
            return ResponseEntity.ok(new MsgRes("Посылка не найдена"));
        }
    }

    /*Добавление посылки
            "idType": {
        "id": ? вводим id Типа поссылки

    },
            "idIndex": {
        "id": ? вводим id Индекса почтвого отдления отправителя

    },
            "adress": "", - Вводим адрес
            "nameOrder": "", - Вводим имя
            "idIndOrd": {
        "id": ?, вводим id Индекса почтвого отдления адресанта
    }*/
    @PostMapping("/add")
    public ResponseEntity<Pkg> createPkg(@RequestBody Pkg pkg) {
        return ResponseEntity.ok(pkgService.create(pkg));
    }

    /*Обновление индекса посылок
    "id": ?
            "idType": {
        "id": ? вводим id Типа поссылки

    },
            "idIndex": {
        "id": ? вводим id Индекса почтвого отдления отправителя

    },
            "adress": "", - Вводим адрес
            "nameOrder": "", - Вводим имя
            "idIndOrd": {
        "id": ?, вводим id Индекса почтвого отдления адресанта
    }*/
    @PatchMapping("/update")
    public ResponseEntity updateInd(@RequestBody Pkg pkg) {
        if(!pkg.getIdIndOrd().getId().equals(pkg.getIdIndex().getId())){
            return ResponseEntity.ok(new MsgRes("Посылка пришла в промежуточное отделение"));
        }
        return ResponseEntity.ok(pkgService.update(pkg));

    }
    /*Удаление посылки если она в пункте выдачи
    Так же удаляется история этой посылки*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MsgRes> deletePkg(@PathVariable("id") Integer id){
        Pkg pkg = pkgService.findOne(id);
        if(!pkg.getIdIndOrd().getId().equals(pkg.getIdIndex().getId())){
            return new ResponseEntity(new MsgRes("Посылка еще не дошла до пункта выдачи"), HttpStatus.NOT_ACCEPTABLE);
        }
        if(pkg.getIdIndOrd().getId().equals(pkg.getIdIndex().getId())) {
            try {
                pkgService.delete(id);
                historyService.deleteHis(pkg.getId());
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok(new MsgRes("Адресат забрал послыку"));
    }
}