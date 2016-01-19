package org.pb.request;

public class RequestVoiceMessage extends BaseRequestMessage {
	private String						m_media_id;
	private String						m_format;
	
	
	public String get_media_id() {
		return m_media_id;
	}
	
	public void set_media_id(String media_id) {
		this.m_media_id = media_id;
	}
	
	public String get_format() {
		return m_format;
	}
	
	public void set_format(String format) {
		this.m_format = format;
	}
	
	
	
	
}
