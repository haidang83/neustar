package test;

import webService.IpDetailService;
import bean.GeoPointResponseBean;

public class Test {
	public static void main(String[] a) {
		try {
			String ip = "";
			GeoPointResponseBean response = IpDetailService.getIpData(ip);
			System.out.println(response);

			ip = "54.201.102.202";
			response = IpDetailService.getIpData(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
