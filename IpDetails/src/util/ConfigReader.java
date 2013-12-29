package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
	private static final String SERVICE_METHOD = "service.method";

	private static final String SERVICE_VERSION = "service.version";

	private static final String SERVICE_URL = "service.url";

	private static final String SERVICE_SECRET = "service.secret";

	private static final String SERVICE_APIKEY = "service.apikey";

	private static final String ERROR_INVALID_IP_ADDR = "error.invalid.ip.addr";

	private static final String GENERAL_ERROR_KEY = "error.general";
	
	private static final String ERROR_MSG_PREFIX = "error.msg.prefix";

	//static Logger log = Logger.getLogger(ConfigReader.class.getName());
	
	private static final String PROPERTIES_FILE_LOCATION = "util/config.properties";

	private static Properties prop = null;
	
	static {
		if (prop == null){
			prop = new Properties();
			
			// load a properties file
			loadProperties();
		}
		
	}
	
	public static String getProperty(String name){
		return prop.getProperty(name);
	}
	
	private static void loadProperties(){
		try {
			//load the updated properties file first, if it exists
			InputStream inputStream = ConfigReader.class.getClassLoader()
	                .getResourceAsStream(PROPERTIES_FILE_LOCATION);
			
			prop.load(inputStream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static String getGeneralErrorMsg(){
		return getProperty(GENERAL_ERROR_KEY);
	}
	

	public static String getInvalidIpAddrMsg() {
		return getProperty(ERROR_INVALID_IP_ADDR);
	}
	
	public static String getErrorMsgPrefix(){
		return getProperty(ERROR_MSG_PREFIX);
	}

	public static String getApiKey() {
		return getProperty(SERVICE_APIKEY);
	}

	public static String getSecret() {
		return getProperty(SERVICE_SECRET);
	}

	public static String getServiceUrl() {
		return getProperty(SERVICE_URL);
	}

	public static String getServiceVersion() {
		return getProperty(SERVICE_VERSION);
	}

	public static String getServiceMethod() {
		return getProperty(SERVICE_METHOD);
	}
}
