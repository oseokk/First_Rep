package seok.yun.na.model;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import seok.yun.na.dtos.CinemaDto;
import seok.yun.na.dtos.NoticeDto;
import seok.yun.na.dtos.SCMovieDto;

@Service
public class Notice_Service implements Notice_IService {

private Logger logger = LoggerFactory.getLogger(Notice_Service.class);
	
	@Autowired
	private Notice_IDao dao;

	@Override
	public List<NoticeDto> notice_list() {
		logger.debug("Notice_Service notice_list()");
		return dao.notice_list();
	}

	@Override
	public boolean notice_add(NoticeDto NoticeDto) {
		logger.debug("Notice_Service notice_add()");
		return dao.notice_add(NoticeDto);
	}

	@Override
	public boolean notice_delete(Map<String, String[]> map) {
		logger.debug("Notice_Service notice_delete()");
		return dao.notice_delete(map);
	}

	@Override
	public NoticeDto notice_Detail(String ntc_seq) {
		logger.debug("Notice_Service notice_Detail()");
		return dao.notice_Detail(ntc_seq);
	}

	@Override
	public boolean notice_edit(NoticeDto NoticeDto) {
		logger.debug("Notice_Service notice_edit()");
		return dao.notice_edit(NoticeDto);
	}

	@Override
	public boolean notice_sdelete(NoticeDto NoticeDto) {
		logger.debug("Notice_Service notice_sdelete()");
		return dao.notice_sdelete(NoticeDto);
	}
	

}
