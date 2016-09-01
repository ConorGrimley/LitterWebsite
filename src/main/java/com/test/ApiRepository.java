package com.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Base64;

/**
 * Created by mark on 01/09/2016.
 */
@Repository
public class ApiRepository implements ApiRepositoryService {

    private Logger LOGGER = Logger.getLogger(ApiRepository.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ApiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveData(String data) {

        try {


            String sql = "INSERT INTO test (data) VALUES (:data)";

            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                    .addValue("data", data);

            jdbcTemplate.update(sql,
                    mapSqlParameterSource);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

    }
}
