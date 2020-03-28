package ver09;

import java.util.Scanner;



public class PhoneBookManager  {
	
	Scanner scan = new Scanner(System.in);
	PhoneInfo[] arrPhoneInfo = new PhoneInfo[100];
	int selectMenu = 0, indexArr=0;
	
	public void printMenu(){
		while(true) {
			System.out.println("선택하세요...\n"
					+ "1. 데이터 입력\n"
					+ "2. 데이터 검색\n"
					+ "3. 데이터 삭제\n"
					+ "4. 주소록 출력\n"
					+ "5. 프로그램 종료\n");
			
			selectMenu = scan.nextInt();								
			scan.nextLine();
		
			if( selectMenu<1 || selectMenu>5 ) {
				System.out.println("1~5메뉴 중 선택하세요");
			}
			else {
				switch (selectMenu) {
				case 1:	dataInput();	break;
				case 2:	dataSearch();	break;
				case 3:	dataDelete();	break;
				case 4:	dataAllShow();	break;
				case 5:
					System.out.println("프로그램 종료합니다.");
					System.exit(0);
				}	
			}
		}
	}
	public void dataInput(){
		System.out.println("데이터 입력을 시작합니다.\n");
		String name, phoneNumber, bd;
		
		System.out.println("이름:\n");
		name = scan.next();
		System.out.println("전화번호:\n");
		phoneNumber = scan.next();
		System.out.println("생년월일:\n");
		bd = scan.next();
		
		arrPhoneInfo[indexArr++] = new PhoneInfo(name, phoneNumber, bd);
		System.out.println("데이터 입력이 완료되었습니다.\n");
	}
	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다.\n이름: ");
		String searchName = scan.next();
		try {
			boolean result = false;
			for(int i=0; i <= arrPhoneInfo.length ; i++  ) {
				if(arrPhoneInfo[i].name.equals(searchName)) {
					result = true;
					arrPhoneInfo[i].showPhoneInfo();
					System.out.println("데이터 검색이 완료되었습니다.\n");
					break;
				}
				else result = false;
			}
			System.out.println(result ? "" :"검색결과가 없습니다");
		} catch (NullPointerException e) {	}
		
	}
	public void dataDelete(){
		try {
			System.out.println("데이터 삭제를 시작합니다...\n이름 : ");
			String deleteName = scan.next();
			
			for(int i=0; i <= arrPhoneInfo.length ; i++  ) {
				if(arrPhoneInfo[i].name.equals(deleteName)) {
					System.out.println("데이터 삭제를 시작합니다...");
					for(int j=i; j <= arrPhoneInfo.length ; j++  ) {
						//중간데이터를 삭제하면 한칸씩 인덱스를 당긴다
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
			for(PhoneInfo i : arrPhoneInfo ) {i.showPhoneInfo();}
		} catch (NullPointerException e) { 
			
		}
	}
}

