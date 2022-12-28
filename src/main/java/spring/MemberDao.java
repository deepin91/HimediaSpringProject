package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	// 멤버의 ID를 관리하는 필드
	// 멤버 생성 시 마다 하나씩 증가시켜 중복되지 않도록 관리
	private static long nextId = 0;
	
	// 멤버 정보(객체)를 저장하는 맵 객체를 정의
	// 멤버 정보의 이메일을 키로 사용
	private Map<String, Member> map = new HashMap<>();
	
	// 이메일을 이용해서 멤버 조회
	public Member selectByEmail(String email) {
		//매개변수로 들어온 email과 동일하면 email에 들어있는 member을 조회
		return map.get(email); // email을 갖고 member가 들어가있는
	}
	
	//멤버 정보를 맵에 추가
	public void insert(Member member) {
		this.nextId ++;
		member.setId(this.nextId);
		map.put(member.getEmail(), member);
	}
	
	// 멤버 정보를 업데이트
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	// 모든 멤버의 정보를 반환
	public Collection<Member> selectAll(){
		return map.values();
	}
} 
