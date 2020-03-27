package ver07;


public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int grade;
	
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		
		super(name, phoneNumber);
		this.grade = grade;
		this.major = major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("전공: "+major);
		System.out.println("학년: "+grade);
	}
	
	@Override
	public String toString() {
		return String.format("이름: %s  전화번호: %s  전공: %s  학년: %s",name,phoneNumber,major, grade);
	}
	
	
}
