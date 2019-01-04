package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="BEEHIVE")
public class Beehive {
	
	public Beehive(Integer id, Float lbsHoney) {
		super();
		this.id = id;
		this.lbsHoney = lbsHoney;
	}
	public Beehive(Float lbsHoney) {
		super();
		this.lbsHoney = lbsHoney;
	}
	public Beehive() {
		super();
		
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="beehiveSequence")
	@SequenceGenerator(allocationSize=1, name="beehiveSequence", sequenceName="SQ_BEEHIVE_PK")
	@Column(name="BEEHIVE_ID")
	private Integer id;
	@Column(name="LBS_HONEY")
	private Float lbsHoney;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getLbsHoney() {
		return lbsHoney;
	}
	public void setLbsHoney(Float lbsHoney) {
		this.lbsHoney = lbsHoney;
	}
	@Override
	public String toString() {
		return "Beehive [id=" + id + ", lbsHoney=" + lbsHoney + "]";
	}

}
