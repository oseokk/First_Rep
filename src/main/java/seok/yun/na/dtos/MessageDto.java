package seok.yun.na.dtos;

import java.io.Serializable;
import java.util.Date;
public class MessageDto implements Serializable{
	
	
	
	private static final long serialVersionUID = 7637204285866909294L;
	private int msg_seq  ;
	private String mem_id   ;
	private String frd_id   ;
	private String mcontent ;
	private Date mdate    ;
	private String readchk;
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageDto(int msg_seq, String mem_id, String frd_id, String mcontent, Date mdate, String readchk) {
		super();
		this.msg_seq = msg_seq;
		this.mem_id = mem_id;
		this.frd_id = frd_id;
		this.mcontent = mcontent;
		this.mdate = mdate;
		this.readchk = readchk;
	}
	@Override
	public String toString() {
		return "MessageDto [msg_seq=" + msg_seq + ", mem_id=" + mem_id + ", frd_id=" + frd_id + ", mcontent=" + mcontent
				+ ", mdate=" + mdate + ", readchk=" + readchk + "]";
	}
	public int getMsg_seq() {
		return msg_seq;
	}
	public void setMsg_seq(int msg_seq) {
		this.msg_seq = msg_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getFrd_id() {
		return frd_id;
	}
	public void setFrd_id(String frd_id) {
		this.frd_id = frd_id;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getReadchk() {
		return readchk;
	}
	public void setReadchk(String readchk) {
		this.readchk = readchk;
	}
	
}