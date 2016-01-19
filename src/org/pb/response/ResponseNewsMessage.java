package org.pb.response;

import java.util.List;

public class ResponseNewsMessage extends BaseResponseMessage {

	private int					m_count;
	private List<Article>		m_articles;
	
	public int get_count() {
		return m_count;
	}
	
	public void set_count(int count) {
		this.m_count = count;
	}

	public List<Article> get_articles() {
		return m_articles;
	}

	public void set_articles(List<Article> articles) {
		this.m_articles = articles;
	}
	
	
}
