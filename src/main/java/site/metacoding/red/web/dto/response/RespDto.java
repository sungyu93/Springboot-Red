package site.metacoding.red.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RespDto<T> {
	private Integer code; // 1정상, -1 실패
	private String msg; // 통신에 대한 결과 메시지 담기
	private T body; // body에 대한 값이 항상 다르기 때문에 제네릭 T 사용
}
