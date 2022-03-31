package com.spring.model;

//회원(Object) -> MemberVO
public class MemberVO {
	
	private int num; //회원번호
	private String id; //아이디
	private String pass; //비밀번호
	private String name; //이름
	private int age; //나이
	private String email; //이메일
	private String phone; //전화번호
	
	//생성자 함수 오버로링
	public MemberVO() {
		
	}
	
	
	//num은 입력을 받지 않기 때문에 나머지 6개를 묶어주는 생성자 (source-> constructor using filed)
	public MemberVO(String id, String pass, String name, int age, String email, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}



	//toString()함수: 디버깅할때 사용 (source -> toString())
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	
	//getter, setter 함수: private로 접근 못하는 변수 접근할수 있게 해줌 (source -> Getters and Setters)
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
