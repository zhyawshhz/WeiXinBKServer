package org.pb.request;

public class RequestImageMessage extends BaseRequestMessage {
	private String							m_pic_url;
	private String							m_media_id;
	
	public String get_pic_url() {
		return m_pic_url;
	}
	
	public void set_pic_url(String pic_url) {
		this.m_pic_url = pic_url;
	}

	public String get_media_id() {
		return m_media_id;
	}

	public void set_media_id(String media_id) {
		this.m_media_id = media_id;
	}
	
	
}
