package ver04;

public class PhoneSchoolInfo extends PhoneInfo{

	String major;
	int grade;
	
	
	public PhoneSchoolInfo(String name, String phoneNumber, String major, int grade) {
		
		super(name, phoneNumber);
		this.grade = grade;
		this.major = major;
	}
	
	
}
