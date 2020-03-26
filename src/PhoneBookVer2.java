import java.util.Scanner;

import ver01.PhoneInfo;

public class PhoneBookVer2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("선택하세요...\n"
					+ "1. 데이터 입력\n"
					+ "2. 프로그램 종료\n");
			int val = scan.nextInt();
			String name, phone, bd;
			if(val==1) {
				System.out.println("이름:\n");
				name = scan.next();
				
				System.out.println("전화번호:\n");
				phone = scan.next();
				
				System.out.println("생년월일:\n");
				bd = scan.next();

				PhoneInfo p1 = new PhoneInfo(name, phone, bd);
				p1.showPhoneInfo();
			}
			else if(val==2) {
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
			}
			else {
				System.out.println("잘못입력했습니다.");
			}
		}
	}
}
