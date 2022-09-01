package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.request.users.UpdateDto;

@Getter
public class Users {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public void 패스워드수정(String password) {
		this.password = password;
		// 패스워드 수정하려면 기존값들이 있어야만 한다. (영속화를 안 하면 불가능함)
	}
	
	public void 전체수정(UpdateDto updateDto) {
		this.username = updateDto.getUsername();
		this.password = updateDto.getPassword();
		this.email = updateDto.getEmail();
		// set은 하나하나 만든 거지만 우리는 지금 의미있는 메서드를 만듦
		
	}
	

}
