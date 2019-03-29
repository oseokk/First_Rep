package seok.yun.na.dtos;

public class FriendDto {

	private int frd_seq;
	private String mem_id;
	private String frd_id;
	
	public FriendDto() {
		super();
	}

	public FriendDto(int frd_seq, String mem_id, String frd_id) {
		super();
		this.frd_seq = frd_seq;
		this.mem_id = mem_id;
		this.frd_id = frd_id;
	}
	
	public FriendDto(String mem_id, String frd_id) {
		super();
		this.mem_id = mem_id;
		this.frd_id = frd_id;
	}

	public int getFrd_seq() {
		return frd_seq;
	}

	public void setFrd_seq(int frd_seq) {
		this.frd_seq = frd_seq;
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

	@Override
	public String toString() {
		return "FriendDto [frd_seq=" + frd_seq + ", mem_id=" + mem_id + ", frd_id=" + frd_id + "]";
	}
	
	
}
