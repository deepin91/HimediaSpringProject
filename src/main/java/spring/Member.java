package spring;

import java.time.LocalDateTime;

public class Member {
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	
	void setId(Long id) { //같은 패키지 내로 제한 // id만 set으로
		this.id = id;
	}
	public Long getId() { // 다른 패키지에서도 사용 가능하도록
		return this.id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		//이전 pw와 지금과 동일한지를 확인
		if(this.password.equals(oldPassword)) {
			throw new WrongIdPasswordException(); 
		}
		this.password = newPassword; // 동일하지 않으면 새로생성
	}
} 
