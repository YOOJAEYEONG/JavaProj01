package ver09.jdbcStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {

	private Connection con;
	private Statement stmt;

	//생성자에서는 드라이버에 대한 로드만 진행한다.
	public DeleteSQL() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}

	//Oracle DB에 대한 연결을 진행한다.
	public void connect() {
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"kosmo",
					"1234"
					);
		} catch (SQLException e) {
			System.out.println("DB연결오류");
			e.printStackTrace();
		}
	}
	
	//DB연결, 쿼리 준비, 쿼리전송, 쿼리 실행을 위한 메소드
	private void execute() {
		//여기서 실제 연결을 진행하다.
		connect();
		try {
			stmt = con.createStatement();
			/*
			test1 삭제시 제약조건위배 예외발생
			test99와 같이 DB에 입력되지 않은 레코드 삭제시에는 예외 없이 삭제되지 않음
			 */
			String query = "delete from member where id='test10'";
			int affected = stmt.executeUpdate(query);
			
			System.out.println(affected+"행이 삭제됨");
		
		} catch (SQLException e) {
			System.out.println("쿼리 실행 오류");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	private void close() {
		try {
			if(stmt!=null)	stmt.close(); //stmt객체가 열려있으면 닫는다
			if(con!=null)	con.close();
			System.out.println("자원반납완료");
		} catch (Exception e) {
			System.out.println("자원반납시 오류");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		new DeleteSQL().execute();
	}

}

























