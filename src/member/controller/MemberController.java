package member.controller;


import java.util.ArrayList;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.view.MemberView;

public class MemberController {
	MemberView mView = new MemberView();
	
	public void selectAll() {
		MemberService mService = new MemberService();
		ArrayList<Member> list = mService.selectAll();
		
		if(list.isEmpty()) {
			System.out.println("조회할 회원이 없습니다.");
		}else {
			mView.displayMember(list);
		}
		
	}
	public void insertMember(Member m) {
		MemberService mService = new MemberService();
		int result = mService.insertMember(m);
//		System.out.println("삽입한 행 : " + result);	// 확인용 코드
		
		if(result > 0) {
			System.out.println("회원 가입 성공");
		}else {
			mView.displayError("insert");
		}
		
	}
	public void selectMember(String id) {
		MemberService mService = new MemberService();
		Member member = mService.selectOne(id);
		
		if(member == null) {
			System.out.println("조회할 멤버가 없습니다.");
		}else {
			mView.displayMember(member);
		}
	}
	public void updatePassword(String id, String pwd) {
		MemberService mService = new MemberService();
		int result = mService.updatePassword(id,pwd);
		
		if(result > 0) {
			System.out.println(id + "회원 비밀번호 수정 성공");
		}else {
			mView.displayError("update");
		}
		
		
	
		
	}
	public void deleteMember(String id) {
		MemberService mService = new MemberService();
		int result = mService.deleteMember(id);
		
		if(result > 0) {
			System.out.println(id + "회원 탈퇴 성공");
		}else {
			mView.displayError("delete");
		}
		
		
		
	}
	public void updateEmail(String id, String email) {
		MemberService mService = new MemberService();
		int result = mService.updateEmail(id,email);
		
		if(result > 0) {
			System.out.println("이메일 수정 완료");
		}else {
			mView.displayError("update");
		}
		
	}
	public void selectGender(String gender) {
		MemberService mService = new MemberService();
		ArrayList<Member> list = mService.selectGender(gender);
		
		if(list.isEmpty()) {
			System.out.println("조회할 회원 정보가 없습니다.");
		}else {
			mView.displayMember(list);
		}
		
		
	}
	public void updatePhone(String id, String phone) {
		MemberService mService = new MemberService();
		int result = mService.updatePhone(id, phone);
		
		if(result > 0) {
			System.out.println(phone + "으로 전화번호 수정 완료");
		}else {
			mView.displayError("udpate");
		}
	}
	public void updateAddress(String id, String address) {
		MemberService mService = new MemberService();
		int result = mService.updateAddress(id,address);
		
		if(result > 0) {
			System.out.println("주소 변경 완료");
		}else {
			mView.displayError("update");
		}
		
		
		
		
	}

}
