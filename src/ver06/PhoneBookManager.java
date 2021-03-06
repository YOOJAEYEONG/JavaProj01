package ver06;

import java.util.InputMismatchException;
import java.util.Scanner;
import ver06.MenuSelectException;

public class PhoneBookManager implements MenuItem  {
	

	
	Scanner scan = new Scanner(System.in);
	PhoneInfo[] arrPhoneInfo = new PhoneInfo[100];
	int indexArr = 0;
	
	
	
	public void printMenu(){
		
		int selectMenu = 0 ;
		while(true) {
			System.out.println("\n선택하세요...\n"
					+ "1. 데이터 입력\n"
					+ "2. 데이터 검색\n"
					+ "3. 데이터 삭제\n"
					+ "4. 주소록 출력\n"
					+ "5. 프로그램 종료\n");
			
			try {
				selectMenu = scan.nextInt();								
				//scan.nextLine();
			
				if( selectMenu<1 || selectMenu>5 ) {
					MenuSelectException e = 
							 new MenuSelectException();
					throw e;
				}
				else {
					switch (selectMenu) {
					case MenuItem.SET_DATA:
						dataInput();
						break;
						
					case MenuItem.SEARCH:
						dataSearch();
						break;
						
					case MenuItem.DELETE:
						dataDelete();
						break;
						
					case MenuItem.PRINT_BOOK:
						dataAllShow();
						break;
						
					case MenuItem.EXIT:
						System.out.println("프로그램 종료합니다.");
						System.exit(0);
					}	
				}
			}
			catch (InputMismatchException e) {
					System.out.println("InputMismatchException:숫자를입력하세요");
					scan.nextLine();
					//버퍼날림(nextInt의 단점중 하나: 엔터값이 남아있는 버퍼를 제거 하는 기능)
			}
			catch (MenuSelectException e) {
				System.out.println("2사용자정의예외:메뉴선택이 잘못되었습니다.");
			}
		}
		
	}
	public void dataInput()    {
		int grade;
		int selectInputMenu = 0;
		String name, major, phoneNum, companyName;
		System.out.println("데이터 입력을 시작합니다.\n1.일반  2.동창  3.회사\n");
		
			try {
				selectInputMenu = scan.nextInt();
				if( selectInputMenu<1 || selectInputMenu>3 ) {
					MenuSelectException e = 
							 new MenuSelectException();
					throw e;
				}
				else {
					//공통사항
					System.out.println("이름:\n");
					name = scan.next();
					System.out.println("전화번호:\n");
					phoneNum = scan.next();
					
					switch (selectInputMenu) {
					case SubMenuItem.NORMAL:
						
						arrPhoneInfo[indexArr++] = new PhoneInfo(name, phoneNum);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
						
					case SubMenuItem.CLASSMATE:
						
						System.out.println("전공:\n");
						major=scan.next();
						System.out.println("학년:\n");
						grade=scan.nextInt();
						
						arrPhoneInfo[indexArr++] =
								new PhoneSchoolInfo(name, phoneNum, major, grade);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
						
					case SubMenuItem.COMPANY:
						
						System.out.println("회사:\n");
						companyName = scan.next();
						arrPhoneInfo[indexArr++] =
								new PhoneCompanyInfo(name, phoneNum,companyName);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
					}//switch
				}//else
			} catch (InputMismatchException e) {
				System.out.println("InputMismatchException:숫자를입력하세요");
				scan.nextLine();
				dataInput();
			} catch (MenuSelectException e) {
				System.out.println("1~3숫자를입력하세요");
				scan.nextLine();
				dataInput();
			}
		
		
	}
	public void dataSearch() {
		System.out.println("데이터 검색을 시작합니다.\n이름:\n");
		try {
			String searchName = scan.next();
			for(int i=0; i <= arrPhoneInfo.length ; i++  ) {
				if(arrPhoneInfo[i].getName().equals(searchName) ) {
					((PhoneInfo) arrPhoneInfo[i]).showPhoneInfo();
					System.out.println("데이터 검색이 완료되었습니다.\n");
					break;
				}
			}
			System.out.println("검색종료");
		} catch (NullPointerException e) {
			System.out.println("찾을 데이터가 없습니다");
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");
		}
		
	}
	public void dataDelete(){
		System.out.println("데이터 삭제를 시작합니다.\n이름 : \n");
		
		try {
			String deleteName = scan.next();
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
				else {
					System.out.println("검색결과없음");
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("데이터가 없습니다.");
		}
		
	}
	public void dataAllShow() {
		try {
			for(PhoneInfo i : arrPhoneInfo ) {
				i.showPhoneInfo();
			}
		} catch (NullPointerException e) {
			System.out.println("출력할 데이터가 없습니다.");
		}
	}
	
	
	
}

