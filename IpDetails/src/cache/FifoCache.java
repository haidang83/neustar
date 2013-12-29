package cache;

import java.util.LinkedHashMap;
import java.util.Map;

import util.ConfigReader;

import bean.IpDataDisplayBean;

public class FifoCache implements CacheInterface {
	public static int MAX_ITEM_IN_CACHE = ConfigReader.maxNumItemInCache();
	private final Map<String, IpDataDisplayBean> cache = new LinkedHashMap<String, IpDataDisplayBean>(MAX_ITEM_IN_CACHE) {
	 
	            /** Serial UID.*/ 
	            private static final long serialVersionUID = 2546245625L;
	 
	            @Override
				protected boolean removeEldestEntry(Map.Entry<String, IpDataDisplayBean> eldest) {
	                return size() > MAX_ITEM_IN_CACHE;
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
