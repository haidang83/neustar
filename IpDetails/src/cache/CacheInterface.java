package cache;

import bean.IpDataDisplayBean;

public interface CacheInterface {
	public IpDataDisplayBean retrieve(String key);
	public void addElement(IpDataDisplayBean e);
}
