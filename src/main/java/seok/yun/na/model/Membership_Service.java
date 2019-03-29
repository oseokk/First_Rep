package seok.yun.na.model;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seok.yun.na.dtos.MembershipDto;

@Service
public class Membership_Service implements Membership_IService {

	
	@Autowired
	private Membership_IDao dao;

	@Override
	public boolean user_dupl(String mem_id) {
		return dao.user_dupl(mem_id);
	}

	@Override
	public boolean user_join(MembershipDto membershipDto) {
		return dao.user_join(membershipDto);
	}
	
	@Override
	public MembershipDto user_login(MembershipDto membershipDto) {
		return dao.user_login(membershipDto);
	}
	
	@Override
	public List<MembershipDto> user_confirm(String mem_id) {
		return dao.user_confirm(mem_id);
	}

	@Override
	public boolean user_edit(MembershipDto membershipDto) {
		return dao.user_edit(membershipDto);
	}

	@Override
	public boolean user_delete(String mem_id) {
		return dao.user_delete(mem_id);
	}
}
