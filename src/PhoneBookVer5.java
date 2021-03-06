import java.util.Scanner;

import ver05.MenuItem;
import ver05.PhoneBookManager;

public class PhoneBookVer5 {

	public static void main(String[] args) throws Exception{

		Scanner scan = new Scanner(System.in);
		PhoneBookManager pbmanager = new PhoneBookManager();
		
		while(true) {
			pbmanager.printMenu();
			
			
			int selectMenu = scan.nextInt();
			
			
			switch (selectMenu) {
			case MenuItem.SET_DATA://입력
				
				System.out.println("데이터 입력을 시작합니다.\n1.일반  2.동창  3.회사\n");
				pbmanager.dataInput();
				
				break;
			case MenuItem.SEARCH://검색
				System.out.println("데이터 검색을 시작합니다.\n이름:\n");
				pbmanager.dataSearch(scan.next());
				break;
				
			case MenuItem.DELETE://삭제
				System.out.println("데이터 삭제를 시작합니다.\n이름 : \n");
				pbmanager.dataDelete(scan.next());
				break;
				
			case MenuItem.PRINT_BOOK://주소록출력
				pbmanager.dataAllShow();
				break;
				
			case MenuItem.EXIT:
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
				
			default:
				System.out.println("잘못입력했습니다.");
				
			}		
		}
	}
}

























