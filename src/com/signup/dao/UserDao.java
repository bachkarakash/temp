package com.signup.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.signup.model.User;


public class UserDao implements InfUser
{
	JdbcTemplate jTemplate;
	public JdbcTemplate getjTemplate() {
		return jTemplate;
	}

	public void setjTemplate(JdbcTemplate jTemplate) {
		this.jTemplate = jTemplate;
	}

	@Override
	public Boolean saveUser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,MOBILE_NO,EMAIL_ID,LOCATION)"+" VALUES('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getMobileNo()+"','"+user.getEmailId()+"','"+user.getLocation()+"')";
		System.out.println(sql);
		this.jTemplate.execute(sql);
		return null;
	}

	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		return this.jTemplate.query(sql, new RowMapper<User>(){
			
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				User m = new User();
				m.setUserId(rs.getInt("USER_ID"));
				m.setFirstName(rs.getString("FIRST_NAME"));
				m.setLastName(rs.getString("LAST_NAME"));
				m.setMobileNo(rs.getString("MOBILE_NO"));
				m.setEmailId(rs.getString("EMAIL_ID"));
				m.setLocation(rs.getString("LOCATION"));
				
				
				return m;
			}
		});
		
	}

}
