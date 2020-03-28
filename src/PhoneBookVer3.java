import java.util.Scanner;

import ver03.PhoneBookManager;



public class PhoneBookVer3 {

	public static void main(String[] args) throws Exception{

		Scanner scan = new Scanner(System.in);
		
		
		PhoneBookManager pbmanager = new PhoneBookManager();
		
		int indexArr = 0;
		int val; 
		String name, phoneNum, bd;
		
		while(true) {
			pbmanager.printMenu();
			val = scan.nextInt();
			
			switch (val) {
			case 1://입력
					System.out.println("데이터 입력을 시작합니다.\n이름 : ");
					
					name = scan.next();
					System.out.println("전화번호:\n");
					phoneNum = scan.next();
					System.out.println("생년월일:\n");
					bd = scan.next();
					
					pbmanager.dataInput(indexArr, name, phoneNum, bd);
					indexArr++;
					System.out.println("데이터 입력이 완료되었습니다.\n");
				break;

			case 2://검색
				System.out.println("데이터 검색을 시작합니다.\n이름:\n");
				String searchName = scan.next();
				pbmanager.dataSearch(searchName);
				break;
			case 3://삭제
				System.out.println("데이터 삭제를 시작합니다.\n이름 : \n");
				pbmanager.dataDelete(scan.next());
				
				
				
				
				break;
			case 4://주소록출력
				pbmanager.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
				
			default:
				System.out.println("잘못입력했습니다.");
				break;
			}
		}
	}
}























