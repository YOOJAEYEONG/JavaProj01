import java.util.Scanner;

import ver04.PhoneBookManager;
import ver04.PhoneInfo;

public class PhoneBookVer4 {

	public static void main(String[] args) throws Exception{

		Scanner scan = new Scanner(System.in);
		
		PhoneBookManager pbmanager = new PhoneBookManager();
		
		final int NOMAL = 1;
		final int CLASSMATE = 2;
		final int COMPANY = 3;
		
		final int SET_DATA = 1;
		final int SEARCH = 2;
		final int DELETE = 3;
		final int PRINT_BOOK = 4;
		final int EXIT = 5;
		
		
		
		
		
		while(true) {
			
			pbmanager.printMenu();
			
			switch (scan.nextInt()) {
			case SET_DATA://입력
				
					System.out.println("데이터 입력을 시작합니다.\n1.일반  2.동창  3.회사\n");
					switch (scan.nextInt()) {
					
					case NOMAL:
						pbmanager.dataInput(NOMAL);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
					case CLASSMATE:
						pbmanager.dataInput(CLASSMATE);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
					case COMPANY:
						pbmanager.dataInput(COMPANY);
						System.out.println("데이터 입력이 완료되었습니다.\n");
						break;
					default:
						System.out.println("잘못입력하였습니다.");
						break;
					}

				
				break;
			case SEARCH://검색
				System.out.println("데이터 검색을 시작합니다.\n이름:\n");
				pbmanager.dataSearch(scan.next());
				break;
				
			case DELETE://삭제
				System.out.println("데이터 삭제를 시작합니다.\n이름 : \n");
				pbmanager.dataDelete(scan.next());
				break;
				
			case PRINT_BOOK://주소록출력
				pbmanager.dataAllShow();
				break;
				
			case EXIT:
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
				
			default:
				System.out.println("잘못입력했습니다.");
				
			}		
		}
	}
}

























