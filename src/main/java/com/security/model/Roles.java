package com.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roleId;
	private String userName;
	private String roles;
	
	
}
