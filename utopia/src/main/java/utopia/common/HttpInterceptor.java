package utopia.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import utopia.util.JsonMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author DELL
 *	Http 请求前后监听工具
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
	private static final String START_TIME = "requestStartTime";
	//处理请求实现之前
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI().toString();
		Map paramMap = request.getParameterMap();
		log.info("request start==url:{}, parameter:{}", url, JsonMapper.obj2String(paramMap));
		long start = System.currentTimeMillis();
		request.setAttribute(START_TIME, start);
		return true;
	}
	//请求正常结束之后执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String url = request.getRequestURI().toString();
		@SuppressWarnings("rawtypes")
		//Map paramMap = request.getParameterMap();
		long start = (Long) request.getAttribute(START_TIME);
		long end = System.currentTimeMillis();
		//log.info("finish==url:{}, parameter:{}", url, JsonMapper.obj2String(paramMap));
		log.info("request finish. url:{}, cost:{}",url, end-start);
		removeThreadLocalInfo();
	}
	//请求结束之后执行，任何情况下 包括异常
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		String url = request.getRequestURI().toString();
		//Map paramMap = request.getParameterMap();
		long start = (Long) request.getAttribute(START_TIME);
		long end = System.currentTimeMillis();
		//log.info("request complete==url:{}, parameter:{}", url, JsonMapper.obj2String(paramMap));
		log.info("request complete. url:{}, cost:{}",url, end-start);
		removeThreadLocalInfo();
	}
	
	public void removeThreadLocalInfo() {
		RequestHolder.remove();
	}
	

}