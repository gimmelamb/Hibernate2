package com.olivia.mint.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@Entity
//@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleId;
	private String Make;
	
	/*@ManyToMany(mappedBy="vehicles")
	private List<UserDetails> userlist = new ArrayList<>();*/
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	/*public List<UserDetails> getUserlist() {
		return userlist;
	}
	public void setUserlist(List<UserDetails> userlist) {
		this.userlist = userlist;
	}*/
	
}


