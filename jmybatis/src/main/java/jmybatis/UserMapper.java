package jmybatis;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	//리턴타입, 메서드명, 매개변수
	
	//select
	public ArrayList<UserDTO> getUser();
	//insert
	public void insertUser(UserDTO userDTO);
	//update
	public void updateUser(@Param("name") String name, @Param("user_id") String user_id);
	
	public void deleteUser(String user_id);
	
}
