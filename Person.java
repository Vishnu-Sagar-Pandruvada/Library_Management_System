package pkg_person;

import java.io.Serializable;
import java.util.regex.Pattern;

abstract public class Person implements Serializable{
	protected String name;
	protected String emailid;
	protected String phoneNumber;
	protected String address;
	protected String dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		boolean isValidName=Pattern.matches("[a-zA-Z]+", name);
		if(isValidName)
			this.name=name;
		else
			this.name="default name";
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		boolean isValidDob=Pattern.matches("\\d{2}-\\d{2}-\\d{4}", dob);
		if(isValidDob)
			this.dob = dob;
		else
			this.dob="1-06-2005";
	}
	public Person(String name, String emailid, String phoneNumber, String address, String dob) {
		super();
		this.setName(name);
		this.emailid = emailid;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.setDob(dob);
	}
	public Person() {
		super();
	}

}