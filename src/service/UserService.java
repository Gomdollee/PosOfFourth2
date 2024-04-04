package service;

import dto.User;

public interface UserService {
    /**
     * 회원가입
     */
    public User signup(User user);
}
