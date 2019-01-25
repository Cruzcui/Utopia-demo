package utopia.common;

/* 异常处理
*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import utopia.exception.ParamException;
import utopia.exception.PermissionException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver{
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String url = request.getRequestURL().toString();
		ModelAndView mv;
		String defaultMsg = "System error";//默认异常信息
		
		//判断是json 请求还是 page请求的返回
		if (url.endsWith(".json")) {//项目中所有请求json数据，都使用.json结尾
			if (ex instanceof PermissionException || ex instanceof ParamException) {
				JsonData result = JsonData.fail(ex.getMessage());
				//这里“jsonView",参照spring-servlet.xml 配置
				mv = new ModelAndView("jsonView",result.toMap());
			}else {
				log.error("unknow json exception url:"+ url, ex);
				JsonData result = JsonData.fail(defaultMsg);
				mv = new ModelAndView("jsonView",result.toMap());
			}
		}else if (url.endsWith(".page")) {//项目中所有请求page数据，都使用.page结尾
			log.error("unknown page exception url:"+ url, ex);
			JsonData result = JsonData.fail(defaultMsg);
			mv = new ModelAndView("exception",result.toMap());
		}else {
			log.error("unknow exception url:"+ url, ex);
			JsonData result = JsonData.fail(defaultMsg);
			mv = new ModelAndView("exception",result.toMap());
		}
		return mv;
	}

}
