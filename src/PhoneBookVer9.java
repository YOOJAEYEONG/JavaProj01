
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
		
		
		String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
		String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
		
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		String url = "jdbc:oracle:thin://@localhost:1521:orcl";
		String userid = "hr";
		String userpw = "1234";
		
		
		Connection con = DriverManager.getConnection(url, userid, userpw);
		
		if(con!=null) {
			System.out.println("Oracle DB 연결성공");
		
//			String sql = 
//					" select * from employees where department_id=50 "+
//					" order by employee_id asc";
			String sql = 
					" create table phonebook_tb( " + 
					"    name nvarchar2(20) primary key, " + 
					"    phoneNumber nvarchar2(11), " + 
					"    birthday varchar2(20) " + 
					" )";
			
			Statement stmt = con.createStatement();
			//con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {

				
				String emp_id = rs.getString(1);
				String f_name = rs.getString("first_name");
				String l_name = rs.getString(3);
				java.sql.Date h_date = rs.getDate("hire_date");
				int sal = rs.getInt("salary");
				
				System.out.printf("%s %s %s %s %s \n",
						emp_id, f_name, l_name, h_date, sal);
			}
			rs.close();
			stmt.close();
			con.close();
		}
		else {
			System.out.println("연결실패");
		}
	}
	
}























