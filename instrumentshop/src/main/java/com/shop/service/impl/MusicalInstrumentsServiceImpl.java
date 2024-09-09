package com.shop.service.impl;

import com.shop.mapper.MusicalInstrumentsMapper;
import com.shop.pojo.MusicalInstruments;
import com.shop.service.MusicalInstrumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicalInstrumentsServiceImpl implements MusicalInstrumentsService {

    @Autowired
    private MusicalInstrumentsMapper musicalInstrumentsMapper;

    @Override
    public List<MusicalInstruments> list() {
        return musicalInstrumentsMapper.list();
    }

    @Override
    public MusicalInstruments getMusicalInstrumentsById(int id) {
        return musicalInstrumentsMapper.getMusicalInstrumentsById(id);
    }

    @Override
    public MusicalInstruments getMusicalInstrumentsByName(String name) {
        return musicalInstrumentsMapper.getMusicalInstrumentsByName(name);
    }


}
