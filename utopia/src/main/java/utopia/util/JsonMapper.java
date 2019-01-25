package utopia.util;
/**
 *
json转换工具
 */
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

import org.codehaus.jackson.type.TypeReference;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JsonMapper {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	static {
		objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
		objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
		objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
	}
	
	public static <T> String obj2String (T src) {
		if (src == null) {
			return null;
		}
		try {
			return src instanceof String ? (String)src : objectMapper.writeValueAsString(src);
		} catch (Exception e) {
			log.warn("parse object to String exception  error:{} ",e);
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T string2Object (String src, TypeReference<T> typeReference) {
		if (src == null || typeReference ==  null) {
			return null;
		}
		try {
			if (typeReference.getType().equals(String.class)) {
				return (T) src;
			}else {
				return objectMapper.readValue(src,typeReference);
			}
			
		} catch (Exception e) {
			log.warn("parse string to object exception String:{}, typeReference:{}, error:{} ",src,typeReference.getType(),e);
			return null;
		}
	}
	
}
