package com.lyc.tablayouttest.Contacts;

/**
 * @author ：LYC
 * @date ：Created in 2020/10/14
 * @version:
 * @description：
 */
public class MyContacts {
    private int userId;
    private String userName;
    private String userPhone[];
    private String userEmail[];

    public MyContacts(int userId, String userName, String[] userPhone, String[] userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String[] userPhone) {
        this.userPhone = userPhone;
    }

    public String[] getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String[] userEmail) {
        this.userEmail = userEmail;
    }
}
