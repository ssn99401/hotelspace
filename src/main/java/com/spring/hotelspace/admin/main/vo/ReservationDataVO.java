package com.spring.hotelspace.admin.main.vo;

import org.springframework.stereotype.Component;

@Component
public class ReservationDataVO {
	private String year;
	private String month;
	private int sum;
	private int count;
	
	public ReservationDataVO() {
		
		// TODO Auto-generated constructor stub
	}
	public ReservationDataVO(String year, String month, int sum, int count) {
		super();
		this.year = year;
		this.month = month;
		this.sum = sum;
		this.count = count;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "ReservationDataVO [year=" + year + ", month=" + month + ", sum=" + sum + ", count=" + count + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
