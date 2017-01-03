package org.webwork.find.repository.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.webwork.find.domain.User;
import org.webwork.find.repositor.JdbcCorporate;


//NOT USE
@Repository
public class JdbcCorporateEventDao implements JdbcCorporate{

	private JdbcTemplate jdbcTemple;
	
	@Autowired
	public void setDateSource(DataSource dataSource){
		this.jdbcTemple = new JdbcTemplate(dataSource);
	}
	
	// never use this
	public String updateName(User user) {// never use this
		this.jdbcTemple.update("UPDATE users SET userName = ? WHERE userName = 'Monika'", user.getFirstName());// never use this
		return "dodano";// never use this
	}

	//add user to two tables
	public String addNewUser(User user) {
		String addUserToUsers = "INSERT INTO users (userName, password) VALUES (?, ?)";
		String addUserRole = "INSERT INTO user_roles (userName, role) VALUES (?, 'ROLE_USER')";
		try{
			this.jdbcTemple.update(addUserToUsers, user.getFirstName(), PasswordEncoderGenerator(user.getPassword()));
			this.jdbcTemple.update(addUserRole, user.getFirstName());
			return "Account has created";
		}catch(Exception e){
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	private String PasswordEncoderGenerator(String pass){
		int i =0;
		String hashedPass = null;
		while(i<10){
			//String pass = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPass = passwordEncoder.encode(pass);
			i++;
		}
		return hashedPass;
	}
}
