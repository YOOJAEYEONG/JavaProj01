import ver01.PhoneInfo;

public class PhoneBookVer1 {

	public static void main(String[] args) {

		PhoneInfo p1 = new PhoneInfo("성낙현", "010-7906-3600", "751130");
		PhoneInfo p2 = new PhoneInfo("류상미", "010-7669-4120");
		
		p1.showPhoneInfo();
		p2.showPhoneInfo();//생년월일 입력되지 않음
	}

}
