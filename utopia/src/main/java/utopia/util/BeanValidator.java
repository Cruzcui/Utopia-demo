package utopia.util;
/**
 参数验证工具
 */

import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.collections.MapUtils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import utopia.exception.ParamException;





public class BeanValidator {
	private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
	
	public static <T>Map<String , String> Validated(T t, Class<?>...groups){
		Validator validator = validatorFactory.getValidator();
		Set<?> validateResult = validator.validate(t, groups);
		if (validateResult.isEmpty()) {
			return Collections.emptyMap();
		}else {
			LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();
			Iterator<?> iterator = validateResult.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> violation = (ConstraintViolation<?>) iterator.next();
				errors.put(violation.getPropertyPath().toString(), violation.getMessage());
			}
			return (Map<String, String>) errors;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> validateList(Collection<?> collection) {
		Preconditions.checkNotNull(collection);
		Iterator<?> iterator = collection.iterator();
		@SuppressWarnings("rawtypes")
		Map errors;
		do {
			if (!iterator.hasNext()) {
				return Collections.emptyMap();
			}
			Object object = iterator.next();
			errors = Validated(object, new Class[0]);
		} while (errors.isEmpty());
		return errors;
	}
	
	public static Map<String, String> validateObject(Object first, Object...objects) {
		if (objects != null && objects.length > 0) {
			return validateList(Lists.asList(first, objects));
		}else {
			return Validated(first, new Class[0]);
		}
	}
	
	public static void check(Object param) throws ParamException {
		Map<String, String> map = BeanValidator.validateObject(param);
		if (MapUtils.isNotEmpty(map)) {
			throw new ParamException(map.toString());
		}
		
	}
	
}
