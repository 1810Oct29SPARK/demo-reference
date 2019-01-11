package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BEAR_TYPE")
public class BearType {

	public BearType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BearType(String name) {
		super();
		this.name = name;
	}
	public BearType() {
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO, generator="bearTypeSequence")
	@SequenceGenerator(allocationSize=1, name="bearTypeSequence", sequenceName="SQ_BEAR_TYPE_PK")
	@Column(name="BEAR_TYPE_ID")
	private Integer id;
	@Column(name="BEAR_TYPE_NAME")
	private String name;
	
	//bidirectional mapping, lazily fetched
	@OneToMany(cascade= {CascadeType.ALL, CascadeType.REMOVE}, orphanRemoval=true)
	@JoinColumn(name = "BEAR_TYPE_ID",foreignKey=@ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private List<Bear> bears = new ArrayList<>();
	
	
	//use addBear, removeBear to manipulate bears list. If relationship is being managed
	//by the BearType
	public void addBear(Bear bear) {
		bears.add(bear);
		bear.setBearType(this);
	}

	public void removeBear(Bear bear) {
		bears.remove(bear);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BearType [id=" + id + ", name=" + name + "]";
	}
	public List<Bear> getBears() {
		return bears;
	}
	public void setBears(List<Bear> bears) {
		this.bears = bears;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
