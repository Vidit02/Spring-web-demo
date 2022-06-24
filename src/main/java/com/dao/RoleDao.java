package com.dao;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.RoleBean;

@Repository
public class RoleDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertRole(RoleBean bean) {
		jdbcTemplate.update("insert into roles (rolename) values (?)", bean.getRoleName());
	}

	public List<RoleBean> getAllRoles() {
		List<RoleBean> roles = jdbcTemplate.query("select * from roles",
				new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		return roles;
	}

	public void deleterole(Integer id) {
		jdbcTemplate.update("delete from roles where roleid=?", id);
	}

	public void updaterole(RoleBean bean) {
		jdbcTemplate.update("update role set rolename = ? where roleid = ?", bean.getRoleName(), bean.getRoleid());
	}

	public List<RoleBean> searchRole(String search){
		List<RoleBean> roles = jdbcTemplate.query("select * from roles where rolename like '?%'", new BeanPropertyRowMapper<>(RoleBean.class),new Object[] {
				search
		});
		return roles;
	}
	
	public RoleBean getRoleById(int id) {
		try {

		 	RoleBean rb = jdbcTemplate.queryForObject("select * from roles where roleid=?" , new BeanPropertyRowMapper<>(RoleBean.class),new Object[] {
					id
			});
		 	return rb;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
