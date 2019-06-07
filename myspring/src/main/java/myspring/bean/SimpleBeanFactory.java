package myspring.bean;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.*;

public class SimpleBeanFactory implements BeanFactory {

	private XmlDefinition xmld;

	private Map<String, Object> obj = new HashMap<>();

	public SimpleBeanFactory(XmlDefinition xmld) {
		this.xmld = xmld;
		for (Bean bean : xmld.beans) {
			obj.put(bean.id, null);
		}
	}

	public Object getBean(String id) {
		if (!obj.containsKey(id)) return null;
		Object targ = obj.get(id);
		if (targ != null) return targ;
		Bean bean = xmld.getBean(id);
		ConstructorArgument ctrArg = bean.ctrArg;
		if (ctrArg != null) {
			Object ctrArgObj;
			if (ctrArg.isRef) {
				ctrArgObj = getBean(ctrArg.value);
			} else {
				ctrArgObj = ctrArg.value;
			}
			try {
				Class<?> cls = Class.forName(bean.cls);
				Class<?> argCls = ctrArgObj.getClass();
				Constructor<?> ctr = cls.getConstructor(argCls);
				targ = ctr.newInstance(argCls.cast(ctrArgObj));
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		for (Property property : bean.properties) {
			Object objToSet;
			if (property.isRef) {
				objToSet = getBean(property.value);
			} else {
				objToSet = property.value;
			}
			String name = property.name;
			String setterName = "set" + 
				name.substring(0, 1).toUpperCase() + name.substring(1);
			try {
				Class<?> cls = Class.forName(bean.cls);
				Method setter = cls.getMethod(
					setterName, objToSet.getClass());
				Class<?> argCls = objToSet.getClass();
				setter.invoke(cls.cast(targ), argCls.cast(objToSet));
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}
		return targ;
	}

	public <T> T getBean(String id, Class<T> type) {
		return null;
	}

}