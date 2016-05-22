package com.slogas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transmissions")
public class GasEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="date")
	private String date;
	@Column(name="budince")
	private double budince;
	@Column(name="kapusany")
	private double kapusany;
	@Column(name="lanzhot")
	private double lanzhot;
	@Column(name="baumgarten")
	private double baumgarten;
	
	public GasEntity(String date) {
		super();
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getBudince() {
		return budince;
	}
	public void setBudince(double budince) {
		this.budince = budince;
	}
	public double getKapusany() {
		return kapusany;
	}
	public void setKapusany(double kapusany) {
		this.kapusany = kapusany;
	}
	public double getLanzhot() {
		return lanzhot;
	}
	public void setLanzhot(double lanzhot) {
		this.lanzhot = lanzhot;
	}
	public double getBaumgarten() {
		return baumgarten;
	}
	public void setBaumgarten(double baumgarten) {
		this.baumgarten = baumgarten;
	}
	@Override
	public String toString() {
		return "Dbdao [date=" + date + ", budince=" + budince + ", kapusany=" + kapusany + ", lanzhot=" + lanzhot
				+ ", baumgarten=" + baumgarten + "]";
	}
	

	
}