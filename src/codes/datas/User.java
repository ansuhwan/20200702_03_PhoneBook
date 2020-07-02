package codes.datas;

import java.util.Calendar;

public class User {

	private String name;
	private String phoneNum;
	private int birthYear;

//	현재 한국 나이 구하기

	public int getKoreanAge() {
		Calendar now = Calendar.getInstance();

//		현재나이 계싼
		return now.get(Calendar.YEAR) - this.birthYear + 1;

	}

//	변수 자체를 찍어도 가공된 문구 나오도록
	@Override
	public String toString() {
//		가공된 양식의 string를 이메쏘드로 지장
//		string.format으로 가공된  문장을 리턴하자

//		조경진(33세) : 010-5112-3237

		return String.format("%s(%d세) : %s", this.name, this.getKoreanAge(), this.phoneNum);

	}

	public User(String name, String phoneNum, int birthYear) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthYear = birthYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

}
