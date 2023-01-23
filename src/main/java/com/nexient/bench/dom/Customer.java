package com.nexient.bench.dom;

public class Customer implements Comparable<Customer>{
	private String id;
	private String location;
	private Gender gender;
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Customer(String id, String location, Gender gender, int age) {
		super();
		this.id = id;
		this.location = location;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", location=" + location + ", gender=" + gender + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Customer o) {
		return this.getId().compareTo(o.getId()) ;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Customer c = (Customer) obj;
		return this.getId().equals(c.getId());
	}
	
	
}
