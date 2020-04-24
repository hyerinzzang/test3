package member.model.service;

import static common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		ArrayList<Member> list = mDao.selectAll(conn);
		
		close(conn);
		
		return list;
	}

	public int insertMember(Member m) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		
		int result = mDao.insertMember(conn,m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);	// JDBC는 자동 commit, rollback이 된다. / myBatis는 정상적으로 됨
		}
		
		close(conn);
		return result;
	}

	public Member selectOne(String id) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		
		Member member = mDao.selectOne(conn,id);
		
		close(conn);
		// DML작업이 아니면 commit, rollback이 필요없다.
		
		return member;
	}

	public int updatePassword(String id, String pwd) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = 0;
		
		result = mDao.updatePassword(conn, id, pwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int deleteMember(String id) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		int result = mDao.deleteMember(conn, id);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public int updateEmail(String id, String email) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		int result = mDao.updateEmail(conn, id, email);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Member> selectGender(String gender) {
		Connection conn = getConnection();
		MemberDao mDao = new MemberDao();
		ArrayList<Member> list = mDao.selectGender(conn, gender);
		
		close(conn);
		return list;
	}

	public int updatePhone(String id, String phone) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		int result = mDao.udpatePhone(conn, id, phone);
		
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		
		return result;
	}

	public int updateAddress(String id, String address) {
		MemberDao mDao = new MemberDao();
		Connection conn = getConnection();
		int result = mDao.updateAddress(conn, id, address);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
