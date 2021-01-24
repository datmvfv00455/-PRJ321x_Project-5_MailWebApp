package vn.funix.prj321x.project5.core.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectUtils {

	public static <T> T copyProperties(Object orig, Class<T> clazz) {
		T dest = null;
		try {
			dest = (T) clazz.getDeclaredConstructor().newInstance();
			BeanUtils.copyProperties(dest, orig);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}

	public static <T> T populate(Class<T> clazz, HttpServletRequest request) {

		T object = null;
		try {
			object = (T) clazz.getDeclaredConstructor().newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

}