package ver09;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ver09.jdbcConnect.IConnectImpl;
import ver09.jdbcStatement.DeleteSQL;
import ver09.jdbcStatement.InsertSQL;
import ver09.jdbcStatement.SearchSQL;
import ver09.jdbcStatement.ShowAllSQL;



public class PhoneBookManager {
	
	IConnectImpl icoimpl = new IConnectImpl();
	public PhoneBookManager() {
		
		try {
			String sql = 
					" create table phonebook_tb( " + 
							"    \"이름\" NVARCHAR2(20) primary key, " + 
							"    \"전화번호\" NVARCHAR2(11), " + 
							"    \"생일\" NVARCHAR2(20) " + 
							" )";
			icoimpl.stmt = icoimpl.con.createStatement();
			icoimpl.rs = icoimpl.stmt.executeQuery(sql);
			
			System.out.println("테이블생성됨");
		} catch (SQLSyntaxErrorException e) {
			System.out.println("기존 테이블을 계속사용합니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	final int ADD_DATA = 1;
	final int SEARCH = 2;
	final int DELETE = 3;
	final int SHOW_ALL = 4;
	final int EXIT = 5;
	int selectMenu = 0, indexArr=0;
	Scanner scan = new Scanner(System.in);
	
	public void printMenu(){
		try {
			while(true) {
				System.out.println("선택하세요...\n"
						+ "1. 데이터 입력\n"
						+ "2. 데이터 검색\n"
						+ "3. 데이터 삭제\n"
						+ "4. 주소록 출력\n"
						+ "5. 프로그램 종료\n");
				
				selectMenu = scan.nextInt();								
				scan.nextLine();
				
				if( selectMenu<1 || selectMenu>5 ) 
					System.out.println("1~5메뉴중 선택하세요");
				else {
					switch (selectMenu) {
					case ADD_DATA:	new InsertSQL().execute();	break;
					case SEARCH:	new SearchSQL().execute();	break;
					case DELETE:	new DeleteSQL().execute();	break;
					case SHOW_ALL:	new ShowAllSQL().execute();	break;
					case EXIT:
						icoimpl.close();
						System.out.println("프로그램 종료합니다.");
						System.exit(0);
					}	
				}
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

