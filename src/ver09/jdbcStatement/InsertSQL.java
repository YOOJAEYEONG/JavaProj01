package ver09.jdbcStatement;

import java.sql.SQLException;

import ver09.jdbcConnect.IConnectImpl;

public class InsertSQL extends IConnectImpl {

	
	//쿼리작성 및 실행 메소드
	public void execute() {
		try {
			//4. SQL문 작성
			String query = " INSERT INTO phonebook_tb VALUES (?, ?, ?) ";
			
			//prepared객체 생성 : 생성시 준비한 쿼리문을 인자로 전달한다.
			psmt = con.prepareStatement(query);
			
			//3. DB에 입력값을 사용자로부터 입력받음
			//4. 인파라메터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작
			psmt.setString(1, scanValue("이름: "));
			psmt.setString(2, scanValue("전화번호: "));
			psmt.setString(3, scanValue("생년월일: "));
			
			//쿼리 실행및 결과값 반환
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력되었습니다.");
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		finally {
			//자원반납
			close();
		}
	}
}
