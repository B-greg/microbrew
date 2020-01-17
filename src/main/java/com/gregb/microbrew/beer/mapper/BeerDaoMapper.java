package com.gregb.microbrew.beer.mapper;

import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BeerDaoMapper {

    public static Beer toBeer(ResultSet resultSet) throws SQLException {
        return new Beer(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("brand"),
                resultSet.getDate("created_at"),
                resultSet.getDate("updated_at"));
    }

    public static Map<String, Object> toParameter(Beer beer){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", beer.getId());
        parameters.put("name", beer.getName());
        parameters.put("brand", beer.getBrand());
        parameters.put("created_at", beer.getCreatedAt());
        parameters.put("updated_at", new Date());
        return  parameters;
    }

    public static Map<String, Object> toParameter(BeerForm beerForm){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", beerForm.getName());
        parameters.put("brand", beerForm.getBrand());
        parameters.put("created_at", new Date());
        parameters.put("updated_at", new Date());
        return  parameters;
    }
}
