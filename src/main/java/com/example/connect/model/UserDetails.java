package com.example.connect.model;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;


@NamedQuery(name="UserDetails.findByEmailID", query="select u from UserDetails u where u.email=:email")
@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table(name = "user_dtls")
public class UserDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_status")
	private String status;
	
	@Column(name="user_role")
	private String role;
	
	
}
