package org.pb.response;

public class ResponseMusicMessage extends BaseResponseMessage {
	
	private Music				m_music;

	public Music get_music() {
		return m_music;
	}

	public void set_music(Music music) {
		this.m_music = music;
	}

}
