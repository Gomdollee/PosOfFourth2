package dto;

import java.time.LocalDate;

public class User {
    private int id;
    private String username;      // 유저아이디
    private String password;      // 비밀번호
    private LocalDate registDate; // 등록일
    private String phoneNum;      // 핸드폰번호
    private String name;          // 사용자이름

    public User(int id, String username, String password, LocalDate registDate, String phoneNum, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.registDate = registDate;
        this.phoneNum = phoneNum;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegistDate() {
        return registDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getName() {
        return name;
    }
}
