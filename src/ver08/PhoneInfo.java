package ver08;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PhoneInfo implements Serializable {

	//멤버변수
	protected String name;
	protected String phoneNumber;
	
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
	
	public String toString() {
		return String.format("이름: %s\t전화번호: %s",name,phoneNumber);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		
		if(phoneInfo.name.equals(this.name)) {
			System.out.println("이름비교결과 : 중복저장안됨");
				return true;
		}
		else {
			System.out.println("이름비교결과 : 중복저장안됨");
				return false;
		}
		
	}

}



