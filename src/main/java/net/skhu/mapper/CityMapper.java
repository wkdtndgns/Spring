package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import net.skhu.dto.City;

@Mapper
public interface CityMapper {

	City findOne(int id);
    City findByName(String title);
    List<City> findByDistrictId(int categoryId);
    List<City> findAll();
    void insert(City city);
    void update(City city);
    void delete(int id);

    List<City> findAllOrderBy( @Param("order") String order);



}

