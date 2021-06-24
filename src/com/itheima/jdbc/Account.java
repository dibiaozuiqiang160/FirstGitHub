package com.itheima.jdbc;

/**
 * @author Messi
 * @date 2021/6/22-16:27
 */
public class Account {
    private Integer id;
    private Double balance;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", username='" + username + '\'' +
                '}';
    }
}
