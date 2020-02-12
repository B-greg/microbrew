package com.gregb.microbrew.beer.repository;

import com.gregb.microbrew.beer.exception.BeerNotFoundException;
import com.gregb.microbrew.beer.mapper.BeerDaoMapper;
import com.gregb.microbrew.beer.model.Beer;
import com.gregb.microbrew.beer.model.BeerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class BeerRepositoryImplementation implements BeerRepository {

    private static final String SPACE = " ";
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public long addBeer(BeerForm beerForm) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("Beer")
                .usingGeneratedKeyColumns("id");
        return simpleJdbcInsert.executeAndReturnKey(BeerDaoMapper.toParameter(beerForm)).longValue();
    }

    @Override
    public int updateBeer(Beer beer) {
        StringJoiner sql = new StringJoiner(SPACE)
                .add("update Beer set name = :name,")
                .add("created_at = :created_at,")
                .add("brand = :brand,")
                .add("updated_at = :updated_at")
                .add("where id = :id");
        return namedParameterJdbcTemplate.update(sql.toString(), BeerDaoMapper.toParameter(beer));
    }

    @Override
    public int deleteBeer(Long id) {
        System.out.println("id: " + id);
        StringJoiner sql = new StringJoiner(SPACE)
                .add("delete from Beer")
                .add("where id = :id");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id", id);
        return namedParameterJdbcTemplate.update(sql.toString(), parameters);
    }

    @Override
    public Beer findBeer(Long id) {
        StringJoiner query = new StringJoiner(SPACE)
                .add("SELECT * FROM Beer")
                .add("where id = :id");
        Map<String, Object> parameters = Collections.singletonMap("id", id);
        try {
            return namedParameterJdbcTemplate.queryForObject(
                    query.toString(), parameters, (resultSet, i) ->
                            BeerDaoMapper.toBeer(resultSet)
            );
        } catch (DataAccessException e) {
            throw new BeerNotFoundException(id);
        }
    }

    @Override
    public List<Beer> findByName(String name) {
        StringJoiner query = new StringJoiner(SPACE)
                .add("SELECT * FROM Beer")
                .add("where name LIKE :name");
        Map<String, Object> parameters = Collections.singletonMap("name", "%" + name + "%");
        List<Beer> beers = namedParameterJdbcTemplate.query(
                query.toString(), parameters,
                (resultSet, i) -> BeerDaoMapper.toBeer(resultSet)
        );
        return beers;
    }

    @Override
    public List<Beer> getBeer() {
        String query = "SELECT * FROM Beer ORDER BY id ASC";
        List<Beer> beers = jdbcTemplate.query(
                query, (resultSet, i) -> BeerDaoMapper.toBeer(resultSet)
        );
        return beers;
    }

}
