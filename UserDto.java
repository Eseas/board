package com.fastcampus.ch4.domain;

import java.util.Date;
import java.util.Objects;

public class UserDto {
	String id;
	String pwd;
	String name;
	String email;
	String birth;
	String sns;
	Date reg_date;
	
	public UserDto(
			String id, 
			String pwd, 
			String name, 
			String email,
			String sns) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.sns = sns;
	}

	public UserDto(String id, String pwd, String name, String email, String birth, String sns) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sns = sns;
	}

	public UserDto() {
		return;
	}

	Date up_date;

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		UserDto userDto = (UserDto) obj;
		
		return Objects.equals(id, userDto.id) &&
				Objects.equals(pwd, userDto.pwd);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id, pwd);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public Date getUp_date() {
		return up_date;
	}
	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", birth=" + birth
				+ ", sns=" + sns + ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}
	
}
