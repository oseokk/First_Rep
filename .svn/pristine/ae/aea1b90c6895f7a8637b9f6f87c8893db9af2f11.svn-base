package seok.yun.na.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.NoticeDto;
import seok.yun.na.dtos.SCMovieDto;

@Repository
public class Notice_Dao implements Notice_IDao {

	private Logger logger = LoggerFactory.getLogger(Notice_Dao.class);
	private final String NS = "seok.yun.na.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<NoticeDto> notice_list() {
		
		return sqlSession.selectList(NS+"notice_list");
	}

	//공지사항 작성
	@Override
	public boolean notice_add(NoticeDto NoticeDto) {
		logger.debug("Notice_Dao notice_add() 공지사항작성");
		Integer n = sqlSession.insert(NS+"notice_add", NoticeDto);
		return (n>0)?true:false;
	}

	//공지사항 다중삭제
	@Override
	public boolean notice_delete(Map<String, String[]> map) {
		logger.debug("Notice_Dao notice_delete");
		int n= sqlSession.delete(NS+"notice_delete",map);
		logger.debug("Notice_Dao notice_delete 결과 : {}",n); // slf4j의 문법
		return (n>0)?true:false;
	}

	//공지사항 상세보기
	@Override
	public NoticeDto notice_Detail(String ntc_seq) {
		logger.debug("Notice_Dao notice_Detail");
		NoticeDto dto =  sqlSession.selectOne(NS+"notice_Detail",ntc_seq);
		return dto;
	}

	//공지사항 수정
	@Override
	public boolean notice_edit(NoticeDto NoticeDto) {
		logger.debug("Notice_Dao notice_edit() 공지사항수정");
		Integer n = sqlSession.update(NS+"notice_edit", NoticeDto);
		return (n>0)?true:false;
	}

	//공지사항 단일 삭제
	@Override
	public boolean notice_sdelete(NoticeDto NoticeDto) {
		logger.debug("Notice_Dao notice_sdelete() 공지사항단일삭제");
		Integer n = sqlSession.delete(NS+"notice_sdelete", NoticeDto);
		return false;
	}
	
	
}