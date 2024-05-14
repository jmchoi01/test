package jmybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	// 데이터가 있는 저장소로 접근하는 유일한 객체
	// 직접 DB에 접근해서 데이터를 삽입, 삭제, 조회 등등 조작
	// 할 수 있는 기능을 수행한다. (데이터베이스에서 crud가 가능)
	// 데이터를 실제 DB에 저장 (MVC 패턴에서 Model 역할)
	
	Connection conn = null;
	// preparedstatement 는 쿼리문을 해석해주는 역할
	PreparedStatement pt = null;

	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8 & serverTimezone=UTF";
	String dbId = "root";
	String dbPw = "1234";
	
	// insert문 구현하기
	// user 테이블에 데이터를 저장
	
	public void insertUser(UserDTO userDTO) {
		try {
			
			// JDBC 드라이버 로드
			Class.forName(dbDriver);
			
			// DB랑 연결
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			// sql문, ?가 써진 순서로 변수를 구분함.
			String insertSQL = "insert into user values(?, ?, ?, ?, ?, ?)";
			
			// conn sql문 전송! db로 전달한다는 뜻
			pt = conn.prepareStatement(insertSQL);
			// sql 입력 값 설정
			pt.setString(1, userDTO.getUser_id());
			pt.setString(2, userDTO.getUser_pw());
			pt.setString(3, userDTO.getName());
			pt.setString(4, userDTO.getPhone());
			pt.setString(5, userDTO.getGrade());
			pt.setInt(6, userDTO.getAge());
			
			pt.executeUpdate();
			
			pt.close();
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// select문 구현하기
	public void selectUser() {
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try {
			
			Class.forName(dbDriver);
						
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			
			String selectSQL = "select * from user";
			
			pt = conn.prepareStatement(selectSQL);
			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				UserDTO dto = new UserDTO(rs.getString("user_id"), rs.getString("user_pw"),
						 rs.getString("name"), rs.getString("phone"), rs.getString("grade"),
						 rs.getInt("age"));
				
				users.add(dto);
			}
			// 한 행씩 출력
			for(UserDTO oneuser : users) {
				System.out.println(oneuser);
			}
			
			pt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	


}
