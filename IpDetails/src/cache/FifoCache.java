package cache;

import java.util.LinkedHashMap;
import java.util.Map;

import bean.IpDataDisplayBean;

public class FifoCache implements CacheInterface {
	private static final int MAX = 50;
	
	private final Map<String, IpDataDisplayBean> cache = new LinkedHashMap<String, IpDataDisplayBean>(MAX) {
	 
	            /** Serial UID.*/ 
	            private static final long serialVersionUID = 2546245625L;
	 
	            @Override
				protected boolean removeEldestEntry(Map.Entry<String, IpDataDisplayBean> eldest) {
	                return size() > MAX;
	            }
	        };
	
	
	@Override
	public synchronized IpDataDisplayBean retrieve(String key) {
		return cache.get(key);
	}

	@Override
	public synchronized void addElement(IpDataDisplayBean e) {
		cache.put(e.getIpAddr(), e);
	}
	
}
