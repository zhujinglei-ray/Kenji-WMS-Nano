package com.kenji.wms.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;
}
