package member.view;

import java.sql.Date;
import java.util.Scanner;

import member.controller.MemberController;
import member.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	public void displayMenu() {
		MemberController mControl = new MemberController();
		do {
			System.out.println("***회원 관리 프로그램***");	
			System.out.println("1. 새 회원 등록");
			System.out.println("2. 모든 회원 조회");
			System.out.println("3. 아이디로 회원 조회");
			System.out.println("4. 성별로 회원 조회");
			System.out.println("5. 암호 수정");
			System.out.println("6. 이메일 변경");
			System.out.println("7. 전화번호 변경");
			System.out.println("8. 주소 변경");
			System.out.println("9. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호 선택 : ");
			int no = sc.nextInt();
			sc.nextLine();	// 엔터 제거용
		
		switch(no) {
			case 1 : mControl.insertMember(inputMember()); break;
			case 2 : mControl.selectAll(); break;
			case 3 : mControl.selectMember(inputMemberId()); break;
			case 4 : mControl.selectGender(inputMemberGender()); break;
			case 5 : mControl.updatePassword(inputMemberId(),inputPassword()); break;
			case 6 : mControl.updateEmail(inputMemberId(),inputEmail()); break;
			case 7 : mControl.updatePhone(inputMemberId(),inputPhone()); break;
			case 8 : mControl.updateAddress(inputMemberId(),inputAddress()); break;
			case 9 : mControl.deleteMember(inputMemberId()); break;
			case 0 : System.out.println("시스템을 종료합니다."); return;
			default : System.out.println("잘못된 번호입니다. 다시 입력해 주세요."); break;
		
		
		
		}
		}while(true);
		
	
		
		
	}
	private String inputAddress() {
		System.out.print("변경할 주소를 입력하세요 : ");
		return sc.nextLine();
	}
	private String inputPhone() {
		System.out.print("변경할 전화번호를 입력하세요: ");
		return sc.nextLine();
	}
	private String inputMemberGender() {
		System.out.print("조회할 성별을 입력해주세요(남:M/여:F) : " );
		return sc.nextLine().toUpperCase();
	}
	private String inputEmail() {
		System.out.print("변경할 이메일 입력: ");
		
		return sc.nextLine();
	}
	private String inputPassword() {
		System.out.print("변경할 회원 비밀번호 : ");
		/// 화면단이면 정규표현식이 들어간다.
		return sc.nextLine();
	}
	private String inputMemberId() {
		System.out.print("조회할 회원 아이디: ");
		return sc.nextLine();
	}
	
	private Member inputMember() {
		Member m = new Member();
		System.out.print("아이디를 입력하세요 : ");
		m.setMamberId(sc.nextLine());
		System.out.print("비밀번호를 입력하세요 : ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름을 입력하세요 : ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별을 입력하세요 (남:M/여:F) : ");
		m.setGender(sc.nextLine().toUpperCase());
		System.out.print("이메일을 입력하세요 : ");
		m.setEmail(sc.nextLine());
		System.out.print("핸드폰 번호를 입력하세요 (-포함) : ");
		m.setPhone(sc.nextLine());
		System.out.print("주소를 입력하세요 : ");
		m.setAddress(sc.nextLine());
		System.out.print("나이를 입력하세요 : ");
		m.setAge(sc.nextInt());
		sc.nextLine();	// 엔터 제거용
	
		return m;
		
	}

}
