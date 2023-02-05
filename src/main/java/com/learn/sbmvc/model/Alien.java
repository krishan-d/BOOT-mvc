package com.learn.sbmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

	@Id
	@Column(name = "id")
	private int aid;
	
	@Column(name = "name")
	private String aname;

	public Alien() {
	}

	public Alien(int aid, String aname) {
		this.aid = aid;
		this.aname = aname;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}

}
