package com.hellokoding.springboot.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.awt.*;
import java.net.URISyntaxException;
import java.sql.*;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws URISyntaxException, SQLException {
        SpringApplication.run(Application.class, args);
        Connection conn = null;
        PreparedStatement createPreparedStatment = null;
        ResultSet resultSet = null;
        conn=DriverManager.getConnection("jdbc:h2:~/mydbInHomeDir;AUTO_SERVER=True","","");
        System.out.println("Database connection established");
        String sqlQuery = "Create table Student(St_id number(10),St_name varchar2(30))";
        createPreparedStatment = conn.prepareStatement(sqlQuery);
        createPreparedStatment.executeUpdate();
        createPreparedStatment.close();
        conn.commit();
        conn.close();
        System.out.println("Hey I have created a table");
    }

}
