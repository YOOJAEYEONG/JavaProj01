package ver09.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSQL {

	//멤버 변수 선언
	Connection con;// DB연결을 위한 객체(인스턴스)
	Statement stmt;// 쿼리 전송및 실행을 위한 객체
	
	//생성자
	public InsertSQL() {//객체가 생성되는 시점에 생성자가 호출된다
		try {
			//1. 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			//2. 커넥션 객체를 통해 DB연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"kosmo",
					"1234"
					);
			System.out.println("오라클 DB 연결성공");
					
		} catch (ClassNotFoundException e) {
			//JDBC연동이 안되있는경우(ojdbc6.jar파일이 없거나 연동되지 않았을때 발생)
			System.out.println("오라클 드라이버 로딩 실패");
			 e.printStackTrace();
		} catch (SQLException e) {
			//계정명, 커넥션 url 이 잘못되는경우
			System.out.println("DB연결실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알수없는 예외발생");
			e.printStackTrace();
		}
	}// InsertSQL
	
	//쿼리작성 및 실행 메소드
	private void execute() {
		try {
			//3. statement객체 생성을 위한 메소드 호출
			stmt = con.createStatement();
			//4. SQL문 작성
			String sql = "insert into member values " +
					" ('test4', '4444', '사길동', sysdate) ";
			//쿼리 실행및 결과값 반환
			/*
			excuteUpdate() : 쿼리문이 insert/update/delete와 같이
				기존 레코드에 영향을 미치는 쿼리를 실행할때 사용한다.
				실행 후 영향을 받은 행의 갯수(int)가 반환된다.
			excuteQuery() : 쿼리문이 select일때 호출하는 메소드로
				레코드에 영향을 미치지 않는 쿼리를 실행한다. 즉, 조회만 하고
				반환타입은 ResultSet이다.
			 */
			int affected = stmt.executeUpdate(sql);
			System.out.println(affected+"행이 입력되었습니다.");
		} catch (SQLException e) {
			System.out.println("쿼리 실행에 문제 발생");
		}
		finally {
			//자원반납
			close();
		}
	}
	private void close() {
		try {
			if(stmt!=null) stmt.close(); //Statement 객체 자원반납
			if(con!=null)	con.close(); //Connection객체 자원반납
			System.out.println("DB자원 반납완료");
		} catch (SQLException e) {
			System.out.println("자원반납시 오류가 발생");
		}
	}//	close
	
	
	public static void main(String[] args) {

		//실행방법 1 : 객체 생성후 참조변수에 대입 후 메소드 호출
		InsertSQL iSQL = new InsertSQL();
		iSQL.execute();
		
		//실행방법 2 : 참조변수 없이 객체 생성과 동시에 메소드 호출
		new InsertSQL().execute();
		
		
	}// main

}
