package ver06;


public class PhoneInfo {

	//멤버변수
	private String name;
	private String phoneNumber;
	
	public PhoneInfo() {}

	
	public PhoneInfo(String name, String phoneNum) {
		this.name = name;
		this.phoneNumber = phoneNum;
	}
	
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
	}
	
	public String getName() {
		return name;
	}

	

}



