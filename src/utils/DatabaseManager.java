package utils;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static final String PROPERTIES_FILE = "resources/database.properties";

    // DB연결 정보 불러오기 (properties파일)
    private static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_FILE))) {
            props.load(reader);
        }
        return props;
    }

    // DB 연결 반환
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = loadProperties();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) {
        try {
            // DB연결 시도
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("=====DB연결 성공O=====");
                conn.close();
            } else {
                System.out.println("=====DB연결 실패X=====");
            }
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}