package dao;

import dto.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDAO {
    /**
     * 회원가입
     */
    public User signup(User user) throws SQLException, IOException;
}
