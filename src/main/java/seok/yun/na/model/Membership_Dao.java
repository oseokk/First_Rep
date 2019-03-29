package seok.yun.na.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import seok.yun.na.dtos.MembershipDto;

@Repository
public class Membership_Dao implements Membership_IDao {

	private final String NAME = "seok.yun.na."; // namepspace 정해야함
	private Logger logger = LoggerFactory.getLogger(Membership_Dao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	//PasswordEncoder : 화면에서 입력된 값을 암호화 시킴
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean user_join(MembershipDto MembershipDto) {
		String encPassword = passwordEncoder.encode(MembershipDto.getMem_pw());
		MembershipDto.setMem_pw(encPassword);
		System.out.println(MembershipDto.getMem_pw());
		logger.debug("Membership_Dao user_join() 회원가입");
		//암호화 된 비밀번호를 DB에 저장
		int n =  sqlSession.insert(NAME+"user_join", MembershipDto);
		return (n>0)?true:false;
	}
	
	@Override
	public MembershipDto user_login(MembershipDto MembershipDto) {
		System.out.println("service dto: "+MembershipDto);
		System.out.println("멤버쉽서비스 dto");
		logger.debug("Membership_Dao user_login() 로그인");
		String pw = sqlSession.selectOne(NAME+"selString",MembershipDto);
		String rawPw = MembershipDto.getMem_pw();
		System.out.println("DB에 입력된  PW  : "+pw);
		System.out.println("화면에서 입력받은  PW  : "+rawPw);
		//입력PW와 DB에 저장된 PW 비교하여 유효성 판단
		if(passwordEncoder.matches(rawPw, pw)) {
			System.out.println("비밀번호 일치");
			return (MembershipDto)sqlSession.selectOne(NAME+"user_login",MembershipDto);
		}else {
			return null;
		}
	}
	
	@Override
	public List<MembershipDto> user_confirm(String mem_id){
		logger.debug("Membership_Dao user_confirm() 회원정보조회");
		List<MembershipDto> lists = sqlSession.selectList(NAME+"user_confirm", mem_id);
		return lists;
	}
	
	@Override
	public boolean user_edit(MembershipDto membershipDto) {
		// Dto에 임의 컬럼을 만들어서 , 화면에서 현재 비밀번호를 입력해서 담아줌
		String nowPw = membershipDto.getNowPw();
		logger.debug("Membership_Dao user_edit 세션아이디 저장");
		//DB에 저장되어 있는 비밀번호
		String pw= sqlSession.selectOne(NAME+"selString",membershipDto);
 		System.out.println("디비입력  PW  : "+pw);
		System.out.println("입력받은  PW  : "+nowPw);
		System.out.println(passwordEncoder.matches(nowPw, pw));
		//nowPw, pw 를 비교하여 일치하면 변경 비밀번호에 입력된 값을 담아줘서 암호화 시킴
		if(passwordEncoder.matches(nowPw, pw)){
			System.out.println("비밀번호 일치");
			System.out.println("수정한 비밀번호 암호화");
			String encPassword = passwordEncoder.encode(membershipDto.getMem_pw());
			membershipDto.setMem_pw(encPassword);
			System.out.println("암호화된 비밀번호 = "+membershipDto.getMem_pw());
			logger.debug("Membership_Dao user_edit() 회원정보수정");
			int n =  sqlSession.update(NAME+"user_edit",membershipDto);
			return (n>0)?true:false;
		}else {
			System.out.println("비밀번호불일치");
			return false;
		}
	}
	
	@Override
	public boolean user_dupl(String mem_id) {
		logger.debug("Membership_Dao user_dupl() 아이디 중복 검사");
		Integer n = sqlSession.selectOne(NAME+"user_dupl", mem_id);
		return (n>0)?false:true; // true : 중복있음, false: 사용가능
	}


	@Override
	public boolean user_delete(String mem_id) {
		logger.debug("Membership_Dao user_delete() 회원탈퇴");
		int n =  sqlSession.update(NAME+"user_delete",mem_id);
		return (n>0)?true:false;
	}

	
}
