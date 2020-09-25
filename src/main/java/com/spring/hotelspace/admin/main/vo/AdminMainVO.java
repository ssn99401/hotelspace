package com.spring.hotelspace.admin.main.vo;

import org.springframework.stereotype.Component;

@Component
public class AdminMainVO {

    private int hotelCount;
    private int resCount;
    private int userCount;
    
    
    
    public int getHotelCount() {
        return hotelCount;
    }
    public void setHotelCount(int hotelCount) {
        this.hotelCount = hotelCount;
    }
    public int getResCount() {
        return resCount;
    }
    public void setResCount(int resCount) {
        this.resCount = resCount;
    }
    public int getUserCount() {
        return userCount;
    }
    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }
    public AdminMainVO(int hotelCount, int resCount, int userCount) {
        super();
        this.hotelCount = hotelCount;
        this.resCount = resCount;
        this.userCount = userCount;
    }
    public AdminMainVO() {
        // TODO Auto-generated constructor stub
    }
}

