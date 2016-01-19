package org.pb.request;

public class RequestLocationMessage extends BaseRequestMessage {
	
	private String						m_x;
	private String						m_y;
	private String						m_scale;
	private String						m_label;
	
	public String get_x() {
		return m_x;
	}
	
	public void set_x(String x) {
		this.m_x = x;
	}
	
	public String get_y() {
		return m_y;
	}
	
	public void set_y(String y) {
		this.m_y = y;
	}
	
	public String get_scale() {
		return m_scale;
	}
	
	public void set_scale(String scale) {
		this.m_scale = scale;
	}
	
	public String get_label() {
		return m_label;
	}
	
	public void set_label(String label) {
		this.m_label = label;
	}
}
