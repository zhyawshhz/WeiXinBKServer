package org.pb.util;

import java.io.InputStream;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;

import com.thoughtworks.xstream.XStream;  
import com.thoughtworks.xstream.core.util.QuickWriter;  
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;  
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;  
import com.thoughtworks.xstream.io.xml.XppDriver;  

import org.pb.response.Article;
import org.pb.response.ResponseMusicMessage;
import org.pb.response.ResponseNewsMessage;
import org.pb.response.ResponseTextMessage;
public class XmlUtil {
	
	public static Map<String, String> parse_xml(HttpServletRequest request) throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		
		InputStream is = request.getInputStream();
		
		SAXReader reader = new SAXReader();
		
		Document doc = reader.read(is);
		
		Element root = doc.getRootElement();
		
		List<Element> le = root.elements();
		
		for (Element e : le)
			map.put(e.getName(), e.getText());
		
		is.close();
		is = null;
		return map;
	}
	
	private static XStream m_xstream = new XStream(new XppDriver(){
		public HierarchicalStreamWriter writer(Writer out){
			return new PrettyPrintWriter(out){
				boolean cdata = true;
				public void start_node(String name, Class cls)
				{
					super.startNode(name, cls);
				}
				protected void write_text(QuickWriter writer, String text){
					if (cdata){
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					}else{
						writer.write(text);
					}
				}
			};
		}
	});
	
	public static String text_msg_2_xml(ResponseTextMessage msg)
	{
		m_xstream.alias("xml", msg.getClass());
		return m_xstream.toXML(msg);
	}
	
	public static String music_msg_2_xml(ResponseMusicMessage msg)
	{
		m_xstream.alias("xml", msg.getClass());
		return m_xstream.toXML(msg);
	}
	
	public static String news_msg_2_xml(ResponseNewsMessage msg)
	{
		m_xstream.alias("xml", msg.getClass());
		m_xstream.alias("item", new Article().getClass());
		return m_xstream.toXML(msg);
	}
	
	
}