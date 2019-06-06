package myspring.bean;

public interface BeanFactory {

	public Object getBean(String id);

	public <T> T getBean(String id, Class<T> type);

}