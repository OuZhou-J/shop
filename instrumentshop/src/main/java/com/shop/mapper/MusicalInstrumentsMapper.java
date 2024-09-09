package com.shop.mapper;

import com.shop.pojo.MusicalInstruments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicalInstrumentsMapper {

    @Select("select * from musicalinstruments")
    List<MusicalInstruments> list();

    @Select("select * from musicalinstruments where id = #{id}")
    MusicalInstruments getMusicalInstrumentsById(int id);

    @Select("select * from musicalinstruments where name = #{name}")
    MusicalInstruments getMusicalInstrumentsByName(String name);
}
