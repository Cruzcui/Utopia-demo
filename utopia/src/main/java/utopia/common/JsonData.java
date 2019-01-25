package utopia.common;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonData {
	private boolean ret;
	private String mString;
	private Object data;
	
	
	public JsonData(Boolean ret) {
		this.ret = ret;
	}
	
	public static JsonData success(Object object, String msg) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		jsonData.mString = msg;
		return jsonData;
	}
	
	public static JsonData success(Object object) {
		JsonData jsonData = new JsonData(true);
		jsonData.data = object;
		return jsonData;
	}
	
	public static JsonData fail(String msg) {
		JsonData jsonData = new JsonData(false);
		jsonData.mString = msg;
		return jsonData;
	}
	
	public static JsonData success() {
		JsonData jsonData = new JsonData(true);
		return jsonData;
	}
	
	public HashMap<String, Object> toMap() {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("msg", mString);
		result.put("data",data);
		result.put("ret", ret);
		return result;
		
	}
	
}

