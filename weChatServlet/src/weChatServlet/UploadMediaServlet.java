package weChatServlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 上传素材servlet
 */
@WebServlet(name = "UploadMediaServlet")
public class UploadMediaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadMediaApiUtil uploadMediaApiUtil = new UploadMediaApiUtil();
        String appId = "wx0aa26453a7ec9df7";
        String appSecret = "2819f0c98199daef39cb6220b4d01b96";
        String accessToken = uploadMediaApiUtil.getAccessToken(appId,appSecret);

        String filePath = "C:\\Users\\Chen Xiuhong\\Pictures\\timg (1).jpg";
        File file = new File(filePath);
        String type = "IMAGE";
        JSONObject jsonObject = uploadMediaApiUtil.uploadMedia(file,accessToken,type);
        System.out.println(jsonObject.toString());
    }
}