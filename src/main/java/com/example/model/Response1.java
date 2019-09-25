package com.example.model;

public class Response1 {

	private String msg;
	private boolean flag;
	
	
	
	public Response1(String msg, boolean flag) {
		super();
		this.msg = msg;
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Response [msg=" + msg + ", flag=" + flag + "]";
	}
	
}
