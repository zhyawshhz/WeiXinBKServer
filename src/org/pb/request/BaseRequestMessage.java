package org.pb.request;

public class BaseRequestMessage {
	
	private String 							m_to_user_name;
	private String 							m_from_user_name;
	private long 							m_create_time;
	private String							m_msg_type;
	private long							m_msg_id;
	
	public String get_to_user_name() {
		return m_to_user_name;
	}
	
	public void set_to_user_name(String to_user_name) {
		this.m_to_user_name = to_user_name;
	}
	
	public String get_from_user_name() {
		return m_from_user_name;
	}
	
	public void set_from_user_name(String from_user_name) {
		this.m_from_user_name = from_user_name;
	}

	public long get_create_time() {
		return m_create_time;
	}

	public void set_create_time(long create_time) {
		this.m_create_time = create_time;
	}

	public String get_msg_type() {
		return m_msg_type;
	}

	public void set_msg_type(String msg_type) {
		this.m_msg_type = msg_type;
	}

	public long get_msg_id() {
		return m_msg_id;
	}

	public void set_msg_id(long msg_id) {
		this.m_msg_id = msg_id;
	}
	
	
	
	
}
