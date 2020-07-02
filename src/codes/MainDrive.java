package codes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import codes.datas.User;

public class MainDrive {

//	불러온 연락처 저장할 ArrayList
//	static메쏘드에서도 사용하력ㅎ static 키워드
	static List<User> myUserList = new ArrayList<>();

	public static void main(String[] args) {

//		Git 와 연동해사 전화번호부 만들 예정
		printMenu();
	}

	public static void printMenu() {

		Scanner myScan = new Scanner(System.in);

		while (true) {

//			어떤 메뉴가 있는지 표기
			System.out.println("*******전화번호부*******");
			System.out.println("1) 전화번호 추가  등록");
			System.out.println("2) 전체 전화 번호 목록 조회");
			System.out.println("0) 프로그램 종료");
			System.out.println("=====================");

//			실제 메뉴 입력 받기
			System.out.print("메뉴 선택 :");
			int inputMenu = myScan.nextInt();

//			입력값 확인
			if (inputMenu == 0) {
//				프로그램 종료 => 반복 탈출
				System.out.println("전화 번호부를 종료 합니다..");
				break;
			} else if (inputMenu == 1) {
//				전화 번호 기능 실행
				addPhoneNumToFile();
			} else if (inputMenu == 2) {
//				전화ㅣ 번호 전체 조회
				readAllPhoneNum();

			} else {
//				0,1,2,외의 값이 들어온 경우 대응.
				System.out.println("잘못된 입력헀습니다");
				System.out.println("다시 입력해 주세요");
			}
		}

	}

//	파일에 저장된 전화 번호 목록 출력
	public static void readAllPhoneNum() {
		
//		파일에서 내 연락처 불러올 예정
//		myUserList에서 이미 데이터가 있으단
//		[전부다지우고] 다시 불러오게 하자
		myUserList.clear();

//		파일에 저장된 데이터 -> 자바 프로그램에서 활용 (flie )
//		FlieReader/BufferedReader 이용

//		볼러올 파일의 위치 저정
		File flie = new File("phoneBook.txt");

		try {
//			파일을 실제로 불러오는 클래스
			FileReader fr = new FileReader(flie);

//			한줄씪 한꺼번에 불러오게 하는 클래스 => fr은 한글자씩 fr을 보조해서 한문장으로 
			BufferedReader br = new BufferedReader(fr);

//			모든 연락처를 불러오기 반복

			while (true) {

//				한 줄 통째로 =>IOException처리
				String line = br.readLine();

				if (line == null) {
//					더이상 불러올 내용이 없어서 null이 들어옴
//					다 읽았더=> 무한 반복 탈출

					System.out.println("연락처를 모두 읽어왔습니다");
					break;

				}
//				이줄의 코드가 실행된다 : break를 안만남
//				실제로 파일에 적혀있던 한줄이 line에 담겨있다

//				System.out.println(line);

//				사용자 정보 가공해서 출력하기
//				조경진 (33) : 010-5112-3237양식으로 가공

//				사용자의 이름과 번호 와 나이를 분리해서 변수로 저장하자

//				String 클래스의 split 기능으로 정보항목들을 (, 기준으로) 분리
				String[] userInfos = line.split(",");

//				이름/번호. 나이
				String userName = userInfos[0];
				String userphoneNum = userInfos[1];
//				나이는 저장 하고 계산 =>int
//				string =>int로
				int userBirthYear = Integer.parseInt(userInfos[2]);
				
//				이름/번호/나이 를 가지고 =>user 객체 만들기
				User user = new User(userName, userphoneNum, userBirthYear);
				
//				만들어낸 유저 출력 => User 클래ㅔ스 toString 오버라이딩
//				양식으로ㅓ
				System.out.println(user);
				
//				맴버변수로 만든 내 연락처 목록에 user변수 추가
				myUserList.add(user);
				
				
				
			}
//			while 빠져나옴 : 파일을 다 읽어서 빠져나옴
//			파일 사용을 종료 br fr를 닫자
			br.close();
			fr.close();

		} catch (FileNotFoundException e) {

//			읽어올 파일이 없는 경우
			System.out.println("불러올 파일이 없습니다");
			System.out.println("연락처를 저장하고 다시 시도해주세요");

//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("읽어오던중 문제 발생");
			e.printStackTrace();
		}
		
		System.out.printf("저장된 연락처 갯수 : %d개",myUserList.size());
		
		
	}

//	전화번호 +이름 + 생년 정보 저장 기능.
	public static void addPhoneNumToFile() {

//		저장할 데이터를 입력 받자
		Scanner myScan = new Scanner(System.in);

//		이름String ->폰번String -> 생년int

		System.out.print("이름 입력 :");
		String name = myScan.nextLine();

		System.out.print("전화 번호 입력 :");
		String phoneNum = myScan.nextLine();

		System.out.print("생년 입력 :");
		int birtnYear = myScan.nextInt();

//		변수에 저장한 데이터를 뭈어서 파일로 저장
//		자바에 보조기억장치 내보내기 파일 출력 (SAVE)

//		어느 파일을 이용할껀지 파일명
		File phoneBookFile = new File("phoneBook.txt");

//		파일 저장 파일 쓰기
//		파일에 사용자 정보 저장 =>기존에 내용 이어 붙이기 true 의 역할
		try {
			FileWriter fw = new FileWriter(phoneBookFile, true);

//			fw는 개발자가 다루기 불편하다 => 보조보구로 쓰는게 fw
			BufferedWriter bw = new BufferedWriter(fw);

//			실제로 bw를 이용하서 연락처 정보 저장.

//			3가지 정보를 한줄에 묶어서 저장 
//			ex 조경진 ,010-5112-3237 , 1988 => 한줄짜리 String로 저ㅏ장
			String infoStr = String.format("%s,%s,%d", name, phoneNum, birtnYear);

//			묶인 한줄을 파일에 기록
			bw.append(infoStr);
//			파일을 기록 하고 나면 줄이 바뀌지 않는다 =>System.out.println처럼
//			한줗에 한명씪 =< 줄 바꾸자
			bw.newLine();

//			작업을 완료 => 열어둔 bw, fw 닫자
			bw.close();
			fw.close();

			System.out.println("연락처 저장이 완료 되었습니다");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
