package com.zqy.utils.messagehandle;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseUtil {
    /**
     * 请求转换为消息信息
     * @param request 请求
     * @return 消息信息
     */
    public static Map<String,String> requestDecode(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        try{
            // 将解析结果存储在HashMap中
            InputStream inputStream = request.getInputStream();
            System.out.println(inputStream);
            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            List<Element> elementList = root.elements();
            // 遍历所有子节点
            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
            }
            inputStream.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return map;
    }

    public static boolean response(HttpServletResponse response,String toUserName,String fromUserName,String createTime,String msgType,String content){
        String res = "<xml><ToUserName><![CDATA["+toUserName+"]]></ToUserName><FromUserName><![CDATA["+fromUserName+"]]></FromUserName><CreateTime>+"+createTime+"</CreateTime><MsgType><![CDATA["+msgType+"]]></MsgType><Content><![CDATA["+content+"]]></Content></xml>";
        try{
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println(res);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
