package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	// 회원 정보를 다루는 DAO 객체를 필드로 선언
	@Autowired
	private MemberDao memberDao;
	public MemberRegisterService() {
	}

	// 생성자를 통해서 필드를 초기화
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// 회원 등록을 처리하는 메서드
	// RegisterRequest 타입을 매개변수로 받아서 등록에 성공하면 회원 ID를 반환
	public Long regist(RegisterRequest req) {
		// 이메일 중복 여부를 확인
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("이메일 중복 " + req.getEmail());
		}
		
		// 중복이 아닐 시 회원 등록
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		
		return newMember.getId();			
	}
}

 