package pkg_person;

public class Student extends Person {
	private int rollNo;
	private int std;
	private String divison;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getSrd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public String getDivison() {
		return divison;
	}
	public void setDivison(String divison) {
		this.divison = divison;
	}
	public Student(String name, String emailid, String phoneNumber, String address, String dob, int rollNo, int std,
			String divison) {
		super(name, emailid, phoneNumber, address, dob);
		this.rollNo = rollNo;
		this.std = std;
		this.divison = divison;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", srd=" + std + ", divison=" + divison + ", name=" + name + ", emailid="
				+ emailid + ", phoneNumber=" + phoneNumber + ", address=" + address + ", dob=" + dob + "]";
	}
	
}