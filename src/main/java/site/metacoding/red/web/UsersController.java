package site.metacoding.red.web;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.response.RespDto;

@RequiredArgsConstructor // 생성자 주입
@RestController 
public class UsersController {

	private final UsersDao usersDao;
	

	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {
		return new RespDto<>(1, "성공", usersDao.findById(id));
	}
	
	@GetMapping("/users")
	public RespDto<?> getUsersList(){
		return new RespDto<>(1, "성공", usersDao.findAll());
	}
	
	@PostMapping("/users") // users 테이블을 insert 하겠다는 뜻
	public RespDto<?> insert(JoinDto joinDto) {
		
		// 유효성 검사
		// if(joinDto.getEmail() == null || joinDto.getEmail().equals("")) {
		usersDao.insert(joinDto); //result 값을 받을 이유가 없다. 오류나면 내부적으로 터질 테니까
		// 그래서 처음부터 void라고 지정하셨다.
		return new RespDto<>(1, "회원가입완료", null);
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> deleteById(@PathVariable Integer id){
		usersDao.deleteById(id);
		return new RespDto<>(1, "탈퇴 성공", null);
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> update(@PathVariable Integer id, UpdateDto updateDto){
		// 1번: id로 select 하자. (영속화)
		Users usersPs = usersDao.findById(id);
		
		// 2번: 변경
		usersPs.전체수정(updateDto);
		
		// 3번: 영속화된 오브젝트로 update하기
	
		usersDao.update(usersPs);
		return new RespDto<>(1, "회원수정성공", null);
	}
	
	@PutMapping("/users/{id}/password")
	public RespDto<?> update(@PathVariable Integer id, String password){
		// 1번 영속화
		Users usersPs = usersDao.findById(id);
		// 2번 변경
		usersPs.패스워드수정(password);
		// 3번 전체 update
		usersDao.update(usersPs);
		return new RespDto<>(1, "비밀번호수정성공", null);
	}
}
