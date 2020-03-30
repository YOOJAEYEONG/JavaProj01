

import ver09.PhoneBookManager;

/*
테이블 생성 
이름, 전화번호, 생년월일을 저장할수 있는 테이블을 생성한다.
테이블명 : phonebook_tb
primary key와 같은 제약조건도 걸어준다.
시퀀스 생성
시퀀스명 : seq_phonebook

입력 : dataInput()
PreparedStatement 클래스 이용
검색 : dataSearch()
Statement 클래스 이용
삭제 : dataDelete()
PreparedStatement 클래스 이용

위 부분을 DML문을 이용하여 구현한다. 
입력은 insert, 검색은 like를 이용한 select, 삭제는 delete로 구현하면 된다.

 */

public class PhoneBookVer9 {

	public static void main(String[] args) throws Exception{

		
		
		new PhoneBookManager().printMenu();
		
	}
	
}























