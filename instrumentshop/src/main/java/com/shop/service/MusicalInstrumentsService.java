package com.shop.service;

import com.shop.pojo.MusicalInstruments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MusicalInstrumentsService {

    List<MusicalInstruments> list();

    MusicalInstruments getMusicalInstrumentsById(int id);

    MusicalInstruments getMusicalInstrumentsByName(String name);
}
