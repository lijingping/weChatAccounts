package weChatServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class weChatAccounts
 */
@WebServlet("/weChatAccounts")
public class weChatAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
    * 自定义token, 用作生成签名,从而验证安全性
    * */
    private final String TOKEN = "cherry";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 接收、处理、响应由微信服务器转发的用户发送给公众帐号的消息
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        System.out.println("请求进入");
        String result = "";
        try {
            Map<String,String> map = MessageUtil.parseXml(req);

            System.out.println("开始构造消息");
            result = MessageUtil.buildXml(map);
            System.out.println(result);

            if(result.equals("")){
                result = "未正确响应";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常："+ e.getMessage());
        }
        resp.getWriter().println(result);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----开始校验签名-----");
    }
}
