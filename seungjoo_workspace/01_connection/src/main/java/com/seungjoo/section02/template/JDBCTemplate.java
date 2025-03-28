package com.seungjoo.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {
    //db 연결 후 연결된 Connection 객체를 반환
    public static Connection getConnection() { //클래스명.으로 호출될 수 있도록 정적 메서드로 만듬
        Properties prop = new Properties();
        Connection conn = null;

        try {
            prop.load(new FileReader("src/main/java/com/seungjoo/connection-config.properties"));
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection conn){
        {
            try {
                if(conn != null && conn.isClosed())
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
