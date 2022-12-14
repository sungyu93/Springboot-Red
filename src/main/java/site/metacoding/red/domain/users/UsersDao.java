package site.metacoding.red.domain.users;

import java.util.List;

import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;

public interface UsersDao {
	public void insert(JoinDto joinDto);
	public Users findById(Integer id);
	public List<Users> findAll();
	public void deleteById(Integer id);
	public void update(Users users); // dto를 import 할 때는 패키지 구분 잘 하기
}
