package com.petsalone.core;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "My_Pet")
public class My_Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer petId;
	// the name
	private String name;
	@Column
	// @DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	// missing since
	private Date missingSince;
	@Column
	@Lob
	private byte[] petImg;
	// type
	// 1 = Cat, 2 = Dog, 3 = Hamster, 4 = Bird, 5 = Rabbit, 6 = Fish, 7 =
	// Lizard, 8 = Horse, 9 = Gerbil, 10 = Tortoise
	@Column
	private String petType;
	

	public My_Pet() {
	}

	public My_Pet(Integer petId, byte[] petImg) {
		super();
		this.petId = petId;
		this.petImg = petImg;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public byte[] getPetImg() {
		return petImg;
	}

	public void setPetImg(byte[] petImg) {
		this.petImg = petImg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMissingSince() {
		return missingSince;
	}

	public void setMissingSince(Date missingSince) {
		this.missingSince = missingSince;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	@Override
	public String toString() {
		return "My_Pet_Class [name=" + name + ", missingSince=" + missingSince + ", petType=" + petType + "]";
	}

}