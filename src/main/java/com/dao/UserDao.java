package com.dao;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void inserUser(UserBean user) {
//		stmt.update("insert into users (firstname,email,password,profile) values (?,?,?,?) ",user.getFname(),user.getEmail(),user.getPassword(),user.getProfile());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		stmt.update(con -> {
			PreparedStatement ps = con.prepareStatement("insert into users (firstname,email,password) values (?,?,?)",
					new String[] { "userid" });
			ps.setString(1, user.getFname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			return ps;
		}, keyHolder);

		int userId = keyHolder.getKey().intValue();

		updateProfile(userId, user.getProfile());
//
	}

	public void updateProfile(int userId, String profile) {

		// stmt.update("update user_profile where userid = ? ", userId);
		stmt.update("insert into user_profile (userid,profile,active)  values (?,?,true)", userId, profile);
		// read order by
	}
}
