package org.pb.server;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.pb.response.ResponseTextMessage;
import org.pb.util.MsgType;
import org.pb.util.XmlUtil;

public class CoreService {
	
	public static String process(HttpServletRequest request)
	{
		String resp_xml_msg = null;
		try
		{
			String resp_msg = "msg_type is undefined!!!";
			Map<String, String> req_map = XmlUtil.parse_xml(request);
			
			String from_user_name = req_map.get("FromUserName");
			String to_user_name = req_map.get("ToUserName");
			String msg_type = req_map.get("MsgType");
			
			ResponseTextMessage msg = new ResponseTextMessage();
			msg.set_from_user_name(from_user_name);
			msg.set_to_user_name(to_user_name);
			msg.set_create_time(new Date().getTime());
			msg.set_msg_type(MsgType.REQ_MESSAGE_TYPE_TEXT);
			msg.set_func_flag(0);
			
			if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_TEXT))
			{
				resp_msg = "这是文本信息！";
			}
			else if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_IMAGE))
			{
				resp_msg = "This is a image!";
			}
			else if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_LINK))
			{
				resp_msg = "This is a link!";
			}
			else if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_LOCATION))
			{
				resp_msg = "This is a location!";
			}
			else if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_VOICE))
			{
				resp_msg = "This is a voice!";
			}
			else if (msg_type.equals(MsgType.REQ_MESSAGE_TYPE_EVENT))
			{
				String ev_type = req_map.get("Event");
				if (ev_type.equals(MsgType.EVENT_TYPE_SUBSCRIBE))
				{
					resp_msg = "thanks for subscribe!!!!";
				}
				else if (ev_type.equals(MsgType.EVENT_TYPE_UNSUBSCRIBE))
				{
					resp_msg = "thanks for unsubscribe!!!";
				}
				else if (ev_type.equals(MsgType.EVENT_TYPE_CLICK))
				{
					resp_msg = "click event is unauth!!!";
				}
				else
				{
					resp_msg = "msg_type is undefined!!!";
				}
			}
			else 
			{
				resp_msg = "msg_type is undefined!!!";
			}
			
			msg.set_content(resp_msg);
			
			resp_xml_msg = XmlUtil.text_msg_2_xml(msg);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return resp_xml_msg;
	}

}
