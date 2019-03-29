package seok.yun.na.model;

import java.util.List;

import seok.yun.na.dtos.MembershipDto;

public interface Membership_IDao {

	// 아이디체크
	public boolean user_dupl(String mem_id);
	// 회원가입
	public boolean user_join(MembershipDto membershipDto);
	// 로그인
	public MembershipDto user_login(MembershipDto membershipDto);
	//회원정보조회
	public List<MembershipDto> user_confirm(String mem_id);
	//회원정보수정
	public boolean user_edit(MembershipDto membershipDto);
	//회원탈퇴
	public boolean user_delete(String mem_id);
	
}
