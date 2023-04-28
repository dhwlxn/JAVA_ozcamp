package com.dto;

public class CommentDTO {

	//관례적으로 user테이블의 컬럼명을 변수로 지정한다.
	int UID;
	int CID;
	String reply;

	public CommentDTO(int UID, int CID) {
		this(UID,UID, " ");
	}
	public CommentDTO(int UID, int CID, String reply) {
		this.UID = UID;
		this.CID = CID;
		this.reply = reply;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cID) {
		CID = cID;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@Override
	public String toString () {
		return "CommentDTO[UID = "+UID+",CID = "+CID+",reply = "+reply+"]";
	}
	
	
	
}
