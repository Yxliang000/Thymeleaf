package cn.com.taiji.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class User implements Serializable{
	private String id;
	@NotEmpty(message="名字不能为空")
	private String name ;
	@NotEmpty(message="年龄不能为空")
	private String age ;
	@NotEmpty(message="性别不能为空")
	private String gender ;
	@NotEmpty(message="电话号码不能为空")
	@Length(min=11,max=11)
	private String phone ;
	private String interest ;
	private boolean zebra;

	public User() {}

	public User(String id, String name, String age, String gender, String phone, String interest) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.interest = interest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
	
	public boolean isZebra() {
		return zebra;
	}

	public void setZebra(boolean zebra) {
		this.zebra = zebra;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone
				+ ", interest=" + interest + "]";
	}

	
}
