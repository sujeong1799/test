package domain;

public class MemberVO {
	
/*
create table member(
id varchar(100) not null,
password varchar(100) not null,
email varchar(100) not null,
birth int,
reg_date datetime default now(),
last_login datetime,
Primary key(id));
*/
	
	private String id;
	private String password;
	private String email;
	private int birth;
	private String reg_date;
	private String last_login;
	
	//생성자
	
	public MemberVO() {}

	// 로그인 생성자
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	// modify 생성자
	public MemberVO(String id) {
		this.id = id;
	}
	
	// 등록 생성자


	public MemberVO(String id, String password, String email, int birth) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.birth = birth;
	}


	// 회원리스트 생성자
	public MemberVO(String id, String email, String reg_date) {
		this.id = id;
		this.email = email;
		this.reg_date = reg_date;
	}

	// 회원정보보기 생성자
	public MemberVO(String id, String email, int birth, String reg_date, String last_login) {
		this.id = id;
		this.email = email;
		this.birth = birth;
		this.reg_date = reg_date;
		this.last_login = last_login;
	}

	// 정보수정 생성자
	public MemberVO(String password, String email, int birth) {
		this.password = password;
		this.email = email;
		this.birth = birth;
	}
	
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", email=" + email + ", birth=" + birth + ", reg_date="
				+ reg_date + ", last_login=" + last_login + "]";
	}
	
	// getter / setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	
	

	
	
	
	
}
