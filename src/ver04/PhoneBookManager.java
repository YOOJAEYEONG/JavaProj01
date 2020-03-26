package ver04;

import java.util.Scanner;


public class PhoneBookManager  {
	
	Scanner scan = new Scanner(System.in);
	PhoneInfo[] arrPhoneInfo = new PhoneInfo[100];
	int indexArr = 0;
	
	public void printMenu(){
		System.out.println("\n선택하세요...\n"
				+ "1. 데이터 입력\n"
				+ "2. 데이터 검색\n"
				+ "3. 데이터 삭제\n"
				+ "4. 주소록 출력\n"
				+ "5. 프로그램 종료\n");
	}
	public void dataInput(int humanType){
		
		switch (humanType) {
		case 1:
			
			
			
			
			arrPhoneInfo[indexArr++] = new PhoneInfo(name, phoneNum);
			
			
			break;

		default:
			System.out.println("잘못입력하였습니다.");
			break;
		}
		
		
		
	}
	public void dataSearch(String searchName) {
		
		try {
			for(int i=0; i <= arrPhoneInfo.length ; i++  ) {
				if(arrPhoneInfo[i].getName().equals(searchName)) {
					System.out.println("참진입");
					((PhoneInfo) arrPhoneInfo[i]).showPhoneInfo();
					System.out.println("데이터 검색이 완료되었습니다.\n");
					break;
				}
			}
			System.out.println("검색결과없음");
		} catch (NullPointerException e) {	}
		
	}
	public void dataDelete(String deleteName){
		try {
			for(int i=0; i <= arrPhoneInfo.length ; i++  ) {
				if(arrPhoneInfo[i].getName().equals(deleteName)) {
					System.out.println("일치하는 이름을 찾음");
					
					for(int j=i; j <= arrPhoneInfo.length ; j++  ) {
						arrPhoneInfo[j] = arrPhoneInfo[j+1];
						if(arrPhoneInfo[j+1]==null) {
							System.out.println("데이터 삭제가 완료되었습니다.\n");
							break;
						}
					}
				}
				else if(arrPhoneInfo[i]==null) {
					System.out.println("검색결과없음");
					break;
				}
			}
		} catch (NullPointerException e) {	}
	}
	public void dataAllShow(){
		try {
			for(PhoneInfo i : arrPhoneInfo ) {
				i.showPhoneInfo();
			}
		} catch (NullPointerException e) {	}
	}
	public void setVal() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름:\n");
		String name = scan.next();
		System.out.println("전화번호:\n");
		String phoneNum = scan.next();
		
	
	}

	
	
}

