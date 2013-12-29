package test;

import webService.IpDetailService;
import bean.GeoPointResponseBean;

public class Test {
	public static void main(String[] a) {
		try {
			long before = System.currentTimeMillis();
			String ip = "54.201.102.202";
			GeoPointResponseBean response = IpDetailService.getIpData(ip);
			long after = System.currentTimeMillis();
			System.out.println(response);
			System.out.println("call duration(ms): " + (after - before));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
