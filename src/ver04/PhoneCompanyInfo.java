package ver04;

public class PhoneCompanyInfo extends PhoneInfo {

	String companyName;

	
	public PhoneCompanyInfo(String name, String phoneNumber, String companyName) {
		super(name, phoneNumber);
		this.companyName=companyName;
	}
	

}
