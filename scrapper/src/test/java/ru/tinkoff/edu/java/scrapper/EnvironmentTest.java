package ru.tinkoff.edu.java.scrapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EnvironmentTest extends IntegrationEnvironment {

    @Autowired
    private DataSourceProperties d;

    @Test
    void simpleDbTest() {
        assertDoesNotThrow(this::execute);
    }

    void execute() {
        System.out.println(d.getUrl());
        Connection con = null;
        try {
            con = DriverManager.getConnection(d.getUrl(), d.getUsername(), d.getPassword());
            //Creating a Statement object
            Statement stmt = con.createStatement();
            //Retrieving the data
            ResultSet rs = stmt.executeQuery("select * from link");
            while(rs.next()) {
                System.out.print(rs.getString(1));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}