package Model;

public class Staff {
	int staff_Id;
	String staff_Name;
	long staff_PhoneNo;
	String staff_Email;
	String staff_Password;
	public Staff()
	{
		this.staff_Id=0;
		this.staff_Name=null;
		this.staff_PhoneNo=0;
		this.staff_Email=null;
		this.staff_Password=null;
	}
	public Staff(int id, String staff_Name, long staff_PhoneNo, String staff_Email, String staff_Password)
	{
		this.staff_Id=id;
		this.staff_Name=staff_Name;
		this.staff_PhoneNo=staff_PhoneNo;
		this.staff_Email=staff_Email;
		this.staff_Password=staff_Password;
	}
	public int getStaff_Id() {
		return staff_Id;
	}
	public void setStaff_Id(int staff_Id) {
		this.staff_Id = staff_Id;
	}
	public String getStaff_Name() {
		return staff_Name;
	}
	public void setStaff_Name(String staff_Name) {
		this.staff_Name = staff_Name;
	}
	public long getStaff_PhoneNo() {
		return staff_PhoneNo;
	}
	public void setStaff_PhoneNo(long staff_PhoneNo) {
		this.staff_PhoneNo = staff_PhoneNo;
	}
	public String getStaff_Email() {
		return staff_Email;
	}
	public void setStaff_Email(String staff_Email) {
		this.staff_Email = staff_Email;
	}
	public String getStaff_Password() {
		return staff_Password;
	}
	public void setStaff_Password(String staff_Password) {
		this.staff_Password = staff_Password;
	}

}
