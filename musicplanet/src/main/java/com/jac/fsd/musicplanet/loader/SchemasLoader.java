package com.jac.fsd.musicplanet.loader;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Log4j2
public class SchemasLoader implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SchemasLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource sql = new ClassPathResource("data/schema.sql");
        Stream<String> lines = Files.lines(Paths.get(sql.getURI()));
        String sqlStatementsString = lines.collect(Collectors.joining());
        lines.close();

        String[] sqlStatements = sqlStatementsString.split(";");

        log.info("SchemasLoader Executing SQL statements from schema.sql");
        for(String sqlStatement : sqlStatements) {
            sqlStatement = sqlStatement.trim();
            if(sqlStatement.isBlank()) {
                continue;
            }
            log.info("Executing SQL statement: \n" + sqlStatement);
            jdbcTemplate.execute(sqlStatement);
        }

        // load data from artistsData.sql
        loadData();
    }


    private void loadData() throws Exception {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM artists", Long.class);
        if (count == 0) {
            Resource dataResource = new ClassPathResource("data/artistsData.sql");
            Stream<String> dataLines = Files.lines(Paths.get(dataResource.getURI()));
            String dataSql = dataLines.collect(Collectors.joining());
            dataLines.close();

            String[] dataStatements = dataSql.split(";");

            log.info("Executing SQL statements from data.sql");
            for (String statement : dataStatements) {
                statement = statement.trim();
                if (!statement.isBlank()) {
                    jdbcTemplate.execute(statement);
                }
            }
            log.info("Data loading completed.");
        } else {
            log.info("Data already exists in the artists table. Skipping data.sql execution.");
        }
    }

}
