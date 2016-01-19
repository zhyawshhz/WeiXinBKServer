package org.pb.request;

public class RequestLinkMessage extends BaseRequestMessage {
	
	private String						m_title;
	private String						m_desc;
	private String						m_url;
	
	public String get_title() {
		return m_title;
	}
	
	public void set_title(String title) {
		this.m_title = title;
	}

	public String get_desc() {
		return m_desc;
	}

	public void set_desc(String desc) {
		this.m_desc = desc;
	}

	public String get_url() {
		return m_url;
	}

	public void set_url(String url) {
		this.m_url = url;
	}

}
