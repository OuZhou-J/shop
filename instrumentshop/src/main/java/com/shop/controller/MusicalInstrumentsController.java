package com.shop.controller;

import com.shop.pojo.MusicalInstruments;
import com.shop.pojo.Result;
import com.shop.service.MusicalInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musicalInstruments")
public class MusicalInstrumentsController {

    @Autowired
    private MusicalInstrumentsService musicalInstrumentsService;

    @GetMapping("/list")
    public Result<List<MusicalInstruments>> list() {
        System.out.println("查询所有乐器");
       List<MusicalInstruments> musicalInstruments =  musicalInstrumentsService.list();
       if (musicalInstruments == null) {
           return Result.error("查询失败,请重试");
       }
       return Result.success(musicalInstruments);
    }
}
