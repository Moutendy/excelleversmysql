package com.dailycodework.excel2database.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="LOGIN")
	private String login;

	@Column(name="DEPARTEMENT")
	private String departement;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ROLE_ID", nullable = true, updatable = true)
	private Role role;
}
