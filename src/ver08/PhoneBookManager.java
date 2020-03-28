package ver08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ver08.PhoneInfo;
import ver08.MenuSelectException;

@SuppressWarnings("serial")
public class PhoneBookManager implements MenuItem, Serializable  {






	Scanner scan = new Scanner(System.in);
	HashSet<PhoneInfo> phoneBookSet = new HashSet<PhoneInfo>();


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
						saveFile();
						System.out.println("주소록에 "+phoneBookSet.size()+"명이 저장되었습니다.");	    
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
		String name = "", major, phoneNum, companyName;
		System.out.println("데이터 입력을 시작합니다.\n1.일반  2.동창  3.회사\n");

			try {
				selectInputMenu = scan.nextInt();
				if(  selectInputMenu<1 || selectInputMenu>3 ) {
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

						PhoneInfo personNormal = new PhoneInfo(name, phoneNum);
						saveCheckData(personNormal);
						break;

					case SubMenuItem.CLASSMATE:

						System.out.println("전공:\n");
						major=scan.next();
						System.out.println("학년:\n");
						grade=scan.nextInt();

						PhoneInfo classMate = new PhoneSchoolInfo(name, phoneNum, major, grade);
						saveCheckData(classMate);
						break;


					case SubMenuItem.COMPANY:

						System.out.println("회사:\n");
						companyName = scan.next();

						PhoneInfo CompanyMate = new PhoneCompanyInfo(name, phoneNum,companyName);
						saveCheckData(CompanyMate);
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
			
			Iterator<PhoneInfo> itr = phoneBookSet.iterator();
			Iterator<PhoneInfo> itr2 = phoneBookSet.iterator();
			boolean searchResult=false;
			
			while(itr.hasNext()) {
				if(itr2.next().name.contains(searchName)) {
					searchResult = true;
					break;
				}
				else	itr.next();
			}
			if(searchResult)	System.out.println(itr.next());
			else				System.out.println("검색결과가 없습니다.");
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void dataDelete(){
		System.out.println("데이터 삭제를 시작합니다.\n이름 : \n");
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();
		Iterator<PhoneInfo> itr2 = phoneBookSet.iterator();
		boolean searchResult=false;

		try {
			String searchName = scan.next();
			
			while(itr.hasNext()) {
				if(itr2.next().name.contains(searchName)) {
					searchResult = phoneBookSet.remove(itr.next());
				}
				else	itr.next();
			}
			if(searchResult)	System.out.println(searchName+"은 삭제되었습니다.");
			else				System.out.println(searchName+"은 주소록에 없습니다.");
			
		} catch (NullPointerException e) {
			System.out.println("데이터가 없습니다.");
		}

	}
	public void dataAllShow() {
		Iterator<PhoneInfo> itr = phoneBookSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(String.valueOf(itr.next()));
			//null일 경우 예외를 발생시키지 않고 null을 출력한다
		}
		
	}
	public void saveCheckData(PhoneInfo newCase) {
		if(false == phoneBookSet.add(newCase)) {
			System.out.println(newCase.name+" 의 중복된 이름이 발견되었습니다. (덮어쓰기 1:예 / 2:아니오)");

			if(scan.nextInt()==1) {
				phoneBookSet.remove(newCase);
				phoneBookSet.add(newCase);
				System.out.println("데이터 입력이 완료되었습니다.\n");
			}
			else	System.out.println("저장취소");
			
		}
		else	System.out.println("데이터 입력이 완료되었습니다.\n");
	}
	public void saveFile() {
		try {
			String src = "C:/02WorkSpace/JavaProj01/src/ver08/AddressBook.obj";
			
			FileOutputStream fileOut = new FileOutputStream(src);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(phoneBookSet);
			objOut.close();
			fileOut.close();
			System.out.println("주소록 저장완료");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO에러발생");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void loadFile() {
		String src = "C:/02WorkSpace/JavaProj01/src/ver08/AddressBook.obj";
		try {
			FileInputStream fileIn = new FileInputStream(src);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			phoneBookSet = (HashSet<PhoneInfo>)objIn.readObject();
			/*
			Iterator<PhoneInfo> itr = phoneBookSet.iterator();
			while(itr.hasNext()) {
				System.out.println(""+itr.next());
			}
			*/
			
			System.out.println("주소록 로드완료");
			objIn.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}







