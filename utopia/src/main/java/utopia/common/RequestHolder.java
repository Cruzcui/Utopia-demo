package utopia.common;

import javax.servlet.http.HttpServletRequest;



import utopia.model.TbUser;

public class RequestHolder {
	private static final ThreadLocal<TbUser> userHolder = new ThreadLocal<TbUser>();
	private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	
	public static void add(TbUser user) {
		userHolder.set(user);
	}
	
	public static void add(HttpServletRequest request) {
		requestHolder.set(request);
	}
	
	public static TbUser getCurrentUser() {
		return userHolder.get();
	}
	
	public static HttpServletRequest getCurrentRequset() {
		return requestHolder.get();
	}
	
    public static void remove() {
		userHolder.remove();
		requestHolder.remove();
	}	
	
	
}