package ver07;

public class PhoneCompanyInfo extends PhoneInfo {

	String companyName;

	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName=companyName;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사: "+ companyName);
	}

	@Override
	public String toString() {
		return String.format("이름: %s  전화번호: %s  회사: %s",name,phoneNumber,companyName);
	}
}
