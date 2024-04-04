package dao;

import dto.User;
import utils.DatabaseManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UserDAOImpl implements UserDAO{
    private Properties profile;

    public UserDAOImpl(Properties profile) {
        this.profile = profile;
    }

    @Override
    public User signup(User user) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO users (username, password, registDate, phoneNum, name) VALUES (?, ?, ?, ?, ?)";
        int result = 0;

        try {
            con = DatabaseManager.getConnection(); // 데이터 베이스 연결

            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setDate(3, Date.valueOf(user.getRegistDate()));
            ps.setString(4, user.getPhoneNum());
            ps.setString(5, user.getName());

            result = ps.executeUpdate();
        } finally {
            // 자원 반환
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }
}
