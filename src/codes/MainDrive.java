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

		}

	}

}
