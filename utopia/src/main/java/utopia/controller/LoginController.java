package utopia.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utopia.model.TbUser;
import utopia.service.LoginService;
import utopia.util.ValidateCode;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping("/login.page")
	public void goLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = null;
		String password = null;
		
		Cookie[] cookies = request.getCookies();//取出客户端所有的Cookie
		if(cookies != null && cookies.length > 0){
			//取出cookie中对应的账号和密码信息
			//cookie对象只提供单取键的方法：getName()
			//cookie对象只提供单取值的方法：getValues()
			for(int i = 0; i < 
					cookies.length; i++){
				if("nameCookie".equals(cookies[i].getName())){
					username = cookies[i].getValue();
				}
				if("passwordCookie".equals(cookies[i].getName())){
					password = cookies[i].getValue();
				}
			}
		}
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			//确认存在cookie执行自动登陆
			TbUser user = loginService.findByKeyWord(username);
			if (user != null) {
				if (password.equals(user.getPassword())) {
					//登录成功
					request.getSession().setAttribute("user", user);//将登录成功的对象装到session中
					response.sendRedirect("/admin/index.page");//跳转主页面
					return;
				}
			}
		
		}
		//登陆失败返回登录页面
		String path = "signin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		String ret = request.getParameter("ret");
		String errorMsg = "";
		String code = request.getParameter("code");
		String randomCode = (String) request.getSession().getAttribute(ValidateCode.RANDOMCODEKEY);

		
		//登录验证判断
		if (StringUtils.isBlank(username)) {
			errorMsg = "用户名不能为空";
		}else if (StringUtils.isBlank(password)) {
			errorMsg = "密码不能为空";
		}else if (StringUtils.isBlank(code)) {
			errorMsg = "验证码不能为空";
		}else if (!code.equalsIgnoreCase(randomCode)) {
			errorMsg = "验证码不正确";
		}else {
			//验证码正确，用户名，密码都不为空，进行数据库操作
			TbUser user = loginService.findByKeyWord(username);
			//login success
			if (user != null) {
				if (password.equals(user.getPassword())) {
					//登录成功
					request.getSession().setAttribute("user", user);//将登录成功的对象装到session中
					//七天免登录相关操作
					//5.2 现在需要完成记住我的操作！
					//一个Cookie对象，装一个键值对
					Cookie nameCookie = new Cookie("nameCookie", user.getUserName());
					Cookie passwordCookie = new Cookie("passwordCookie", user.getPassword());
					if (rememberMe != null) {
						//5.3 设置Cookie有效时长！
						nameCookie.setMaxAge(60 * 60 * 24 * 7);//单位是s
						passwordCookie.setMaxAge(60 * 60 * 24 * 7);
						//5.4 设置Cookie的访问路径！
						nameCookie.setPath("/");//任何页面都可以访问Cookie
						passwordCookie.setPath("/");
					}else{
						//如果不被选中，立即将Cookie变为失效状态
						nameCookie.setMaxAge(0);//单位是s
						passwordCookie.setMaxAge(0);
						nameCookie.setPath("/");//任何页面都可以访问Cookie
						passwordCookie.setPath("/");
					}
					//5.5 将Cookie响应回客户端
					response.addCookie(nameCookie);
					response.addCookie(passwordCookie);
					
					
					
					if (StringUtils.isNotBlank(ret)) {
						response.sendRedirect(ret);
					}else {
						response.sendRedirect("/admin/index.page");
						return;
					}
				}
				errorMsg = "密码不正确";
			}
			errorMsg = "用户名不正确";
		
		}
		request.setAttribute("error", errorMsg);
		request.setAttribute("username", username);
		
		if (StringUtils.isNotBlank(ret)) {
			request.setAttribute("ret", ret);
		}
		String path = "signin.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@RequestMapping("/ImgServlet")
	public void getValidateCode(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//设置相应类型，图片格式
		response.setContentType("image/jpeg");
		//设置响应头，阻止浏览器缓存此响应的内容(节约内存)
		response.setHeader("Pragma", "No-cache");
				
		//引用工具类中的方法，绘制验证码图片
		ValidateCode code = new ValidateCode();
		code.getValidateCode(request, response);//调用绘制验证码的方法，绘制图片
	}
	
}
