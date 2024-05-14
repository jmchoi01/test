package jmybatis;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		DBUtil my = new DBUtil();
		
		my.init();
		ArrayList<UserDTO> list = my.getUser();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("[수행 기능 선택]\n**1. 입력 2. 수정 3. 삭제 4. 조회 **\n>>");
			int num = s.nextInt();
			s.nextLine();
			if(num==1) {
				System.out.print("아이디 입력 : ");
				String user_id = s.nextLine();
				System.out.print("비밀번호 입력 : ");
				String user_pw = s.nextLine();
				System.out.print("이름 입력 : ");
				String name = s.nextLine();
				System.out.print("전화번호 입력 : ");
				String phone = s.nextLine();
				System.out.print("등급 입력 : ");
				String grade = s.nextLine();
				System.out.print("나이 입력 : ");
				int age = s.nextInt();
				
				my.insertUser(user_id, user_pw, name, phone, grade, age);
				
			}else if (num ==2) {
				System.out.println("값을 수정합니다");
				System.out.print("바꿀 이름 입력 : ");
				String name = s.nextLine();
				System.out.print("수정할 아이디 입력 :");
				String user_id = s.nextLine();
				
				my.updateUser(name,user_id);
				System.out.println(list);
			}else if (num ==3) {
				System.out.println("값을 삭제합니다");
				System.out.println("삭제할 아이디 입력 : ");
				String user_id = s.nextLine();
				
				my.deleteUser(user_id);
				System.out.println(list);
			}else if (num == 4) {
				
				System.out.println(list);
			}
			
		}
		
			System.out.println("dfdsf");
	}

}
