package codes;

import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class MainDrive {

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
			System.out.println("메뉴 선택 :");
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

			} else {
				System.out.println("잘못된 입력");
				System.out.println("다시 입력");
			}
		}

	}
	
	
//	전화번호 +이름 + 생년 정보 저장 기능.
	public static void addPhoneNumToFile() {
		
//		저장할 데이터를 입력 받자
		Scanner myScan =new Scanner(System.in);
		
//		이름String ->폰번String -> 생년int
		
		System.out.println("이름 입력 :");
		String name =myScan.nextLine();
		
		System.out.println("전화 번호 입력 :");
		String phoneNum = myScan.nextLine();
		
		System.out.println("생년 입력 :");
		int birtnYear = myScan.nextInt();
		
//		변수에 저장한 데이터를 뭈어서 파일로 저장
//		자바에 보조기억장치 내보내기 파일 출력 (SAVE)
		
		
		

	}

}
