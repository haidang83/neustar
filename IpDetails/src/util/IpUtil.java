package util;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
	public static final String UNKNOWN_VALUE = "Unknown";
	private static final String IP_V6_INDICATOR = ":";
	private static final String X_FORWARDED_FOR_HEADER = "X-FORWARDED-FOR";

	public static boolean isNullOrEmpty(String str){
		return str == null || str.trim().isEmpty();
	}

	/**
	 * This trial api key only support ipv4 addr lookup.
	 * So ip addr is only valid if it's not empty and not ipv6
	 * @param ipAddress
	 * @return
	 */
	public static boolean isValidIpAddr(String ipAddress) {
		return !isNullOrEmpty(ipAddress) && !isIpV6Addr(ipAddress);
	}

	private static boolean isIpV6Addr(String ipAddress) {
		return ipAddress.indexOf(IP_V6_INDICATOR) != -1;
	}
	
	public static String getClientIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader(X_FORWARDED_FOR_HEADER);  
        if (IpUtil.isNullOrEmpty(ipAddress)) {  
     	   ipAddress = request.getRemoteAddr();  
        }
		return ipAddress;
	}
}
