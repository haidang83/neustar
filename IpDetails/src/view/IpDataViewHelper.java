package view;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.ParseException;
import org.apache.log4j.Logger;

import cache.CacheInterface;
import cache.FifoCache;

import util.ConfigReader;
import util.IpUtil;
import webService.IpDetailService;
import bean.GeoPointResponseBean;
import bean.GeoPointResponseBean.CityData;
import bean.GeoPointResponseBean.CountryData;
import bean.GeoPointResponseBean.GdsError;
import bean.GeoPointResponseBean.Location;
import bean.GeoPointResponseBean.StateData;
import bean.IpDataDisplayBean;

public class IpDataViewHelper {

	private static final String UNKNOWN_VALUE = "Unknown";
	private static Logger log = Logger.getLogger(IpDataViewHelper.class.getName());
	private static CacheInterface cache = new FifoCache();


	public static IpDataDisplayBean getIpDisplayBean(String ipAddr) throws ParseException, NoSuchAlgorithmException, IOException{
		IpDataDisplayBean displayBean = null;
		if (ConfigReader.isUseCache()){
			displayBean = cache.retrieve(ipAddr);
		}
		
		if (displayBean == null){
			//need to call the api
			displayBean = new IpDataDisplayBean();
			displayBean.setIpAddr(ipAddr);
			GeoPointResponseBean resp = IpDetailService.getIpData(ipAddr);
			populateIpData(resp, displayBean);
			cache.addElement(displayBean);
		}
		return displayBean;
	}

	private static void populateIpData(GeoPointResponseBean response, IpDataDisplayBean displayBean){
		
		if (response == null){
			populateGeneralErrorMsg(displayBean);
		}
		else {
			GdsError gds_error = response.getGds_error();
			if (gds_error != null){
				//gds error, populate error & msg
				displayBean.setError(true);
				String gdsErrorMsg = gds_error.getMessage();
				String gdsHttpCode = gds_error.getHttp_status();
				
				log.error(String.format("gds httpStatus: %s, errorMsg: %s", gdsHttpCode, gdsErrorMsg));
				displayBean.setErrorMsg(ConfigReader.getErrorMsgPrefix() + " " + gdsErrorMsg);
			}
			else if (response.getIpInfo() != null){
				//success, populate ip data
				populateDisplayBean(response, displayBean);
			}
		}

	}

	public static void populateGeneralErrorMsg(IpDataDisplayBean displayBean) {
		displayBean.setError(true);
		displayBean.setErrorMsg(ConfigReader.getGeneralErrorMsg());
	}
	
	public static void populateIpError(IpDataDisplayBean displayBean){
		displayBean.setError(true);
		displayBean.setErrorMsg(ConfigReader.getInvalidIpAddrMsg());
		displayBean.setIpAddr(UNKNOWN_VALUE);

	}

	private static void populateDisplayBean(GeoPointResponseBean response,
			IpDataDisplayBean displayBean) {
		
		displayBean.setError(false);
		Location location = response.getIpInfo().getLocation();
		if (location != null){
			
			CountryData countryData = location.getCountryData();
			if (countryData != null && !IpUtil.isNullOrEmpty(countryData.getCountry())){
				displayBean.setCountry(countryData.getCountry());
			}
			
			StateData stateData = location.getStateData();
			if (stateData != null && !IpUtil.isNullOrEmpty(stateData.getState())){
				displayBean.setState(stateData.getState());
			}
			
			CityData cityData = location.getCityData();
			if (cityData != null && !IpUtil.isNullOrEmpty(cityData.getCity())){
				displayBean.setCity(cityData.getCity());
			}
			
			displayBean.setLongitude(location.getLongitude());
			displayBean.setLatitude(location.getLatitude());
		}
	}
}
