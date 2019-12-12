package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import entities.user;
import dao.loginDao;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("用户名称"+req.getParameter("userName"));
//        System.out.println("用户密码"+req.getParameter("userPassword"));
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        user requestUser = new user(userName,userPassword);
        loginDao loginDao = new loginDao();
        if (loginDao.checkUser(requestUser)){
            //如果存在这个用户我们能够跳转到电商平台页面
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().write("用户名正确");
        }else{
            //如果用户不存在我们就注册或者是重新输入密码和用户名
            resp.getWriter().write("你这个用户名错误");
        }
    }

}
