package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	// 실행에 필요한 객체를 필드로 정의
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() { // 프로그램 전체에서 필요한 모든 것을 만들고 설정해줌.
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return this.memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return this.regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return this.pwdSvc; 
	}
}
