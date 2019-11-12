package com.training.entity;

import java.time.LocalDate;
import java.util.List;

public class TravelDetails {
	private long code;
	private String source;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private String place1;
	private String place2;
	private String place3;
    private long noOfDays;
	private long noOfNights;
	private double cost;
	public TravelDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TravelDetails(long code, String source, String destination, LocalDate startDate, LocalDate endDate,
			String place1, String place2, String place3, long noOfDays, long noOfNights, double cost) {
		super();
		this.code = code;
		this.source = source;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place1 = place1;
		this.place2 = place2;
		this.place3 = place3;
		this.noOfDays = noOfDays;
		this.noOfNights = noOfNights;
		this.cost = cost;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getPlace1() {
		return place1;
	}
	public void setPlace1(String place1) {
		this.place1 = place1;
	}
	public String getPlace2() {
		return place2;
	}
	public void setPlace2(String place2) {
		this.place2 = place2;
	}
	public String getPlace3() {
		return place3;
	}
	public void setPlace3(String place3) {
		this.place3 = place3;
	}
	public long getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}
	public long getNoOfNights() {
		return noOfNights;
	}
	public void setNoOfNights(long noOfNights) {
		this.noOfNights = noOfNights;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "TravelDetails [code=" + code + ", source=" + source + ", destination=" + destination + ", startDate="
				+ startDate + ", endDate=" + endDate + ", place1=" + place1 + ", place2=" + place2 + ", place3="
				+ place3 + ", noOfDays=" + noOfDays + ", noOfNights=" + noOfNights + ", cost=" + cost + "]";
	}
	
	
	
			}
