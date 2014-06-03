package bean;
/**
 * updated in original
 */
public class GeoPointResponseBean {
	private Ipinfo ipinfo;
	private GdsError gds_error;
	
	public Ipinfo getIpInfo() {
		return ipinfo;
	}

	public void setIpInfo(Ipinfo ipInfo) {
		this.ipinfo = ipInfo;
	}

	public GdsError getGds_error() {
		return gds_error;
	}

	public void setGds_error(GdsError gds_error) {
		this.gds_error = gds_error;
	}


	public static class Ipinfo {
		private String ip_address, ip_type;
		private Network Network;
		private Location Location;
		public String getIp_address() {
			return ip_address;
		}
		public void setIp_address(String ip_address) {
			this.ip_address = ip_address;
		}
		public String getIp_type() {
			return ip_type;
		}
		public void setIp_type(String ip_type) {
			this.ip_type = ip_type;
		}
		public Network getNetwork() {
			return Network;
		}
		public void setNetwork(Network network) {
			this.Network = network;
		}
		public Location getLocation() {
			return Location;
		}
		public void setLocation(Location location) {
			this.Location = location;
		}
	}
	
	public static class GdsError {
		private String http_status, message;

		public String getHttp_status() {
			return http_status;
		}

		public void setHttp_status(String http_status) {
			this.http_status = http_status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
	
	public static class Network {
		private String organization, carrier, connection_type, line_speed, ip_routing_type;
		private int asn;
		private Domain Domain;
		public String getOrganization() {
			return organization;
		}
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		
		public String getCarrier() {
			return carrier;
		}
		
		public void setCarrier(String carrier) {
			this.carrier = carrier;
		}
		
		public String getConnection_type() {
			return connection_type;
		}
		
		public void setConnection_type(String connection_type) {
			this.connection_type = connection_type;
		}
		
		public String getLine_speed() {
			return line_speed;
		}
		
		public void setLine_speed(String line_speed) {
			this.line_speed = line_speed;
		}
		
		public String getIp_routing_type() {
			return ip_routing_type;
		}
		
		public void setIp_routing_type(String ip_routing_type) {
			this.ip_routing_type = ip_routing_type;
		}
		
		public int getAsn() {
			return asn;
		}
		
		public void setAsn(int asn) {
			this.asn = asn;
		}
		
		public Domain getDomain() {
			return Domain;
		}
		
		public void setDomain(Domain domain) {
			this.Domain = domain;
		}
	}
	
	public static class Domain {
		private String tld, sld;

		public String getTld() {
			return tld;
		}

		public void setTld(String tld) {
			this.tld = tld;
		}

		public String getSld() {
			return sld;
		}

		public void setSld(String sld) {
			this.sld = sld;
		}
	}
	
	public static class Location {
		private String continent, region;
		private int dma, msa;
		private double latitude, longitude;
		private CountryData CountryData;
		private StateData StateData;
		private CityData CityData;
		public String getContinent() {
			return continent;
		}
		public void setContinent(String continent) {
			this.continent = continent;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public int getDma() {
			return dma;
		}
		public void setDma(int dma) {
			this.dma = dma;
		}
		public int getMsa() {
			return msa;
		}
		public void setMsa(int msa) {
			this.msa = msa;
		}
		public double getLatitude() {
			return latitude;
		}
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public CountryData getCountryData() {
			return CountryData;
		}
		public void setCountryData(CountryData countryData) {
			this.CountryData = countryData;
		}
		public StateData getStateData() {
			return StateData;
		}
		public void setStateData(StateData stateData) {
			this.StateData = stateData;
		}
		public CityData getCityData() {
			return CityData;
		}
		public void setCityData(CityData cityData) {
			this.CityData = cityData;
		}
		
	}
	
	public static class CountryData {
		private String country, country_code, country_cf;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getCountry_code() {
			return country_code;
		}

		public void setCountry_code(String country_code) {
			this.country_code = country_code;
		}

		public String getCountry_cf() {
			return country_cf;
		}

		public void setCountry_cf(String country_cf) {
			this.country_cf = country_cf;
		}
	}
	
	public static class StateData {
		private String state, state_code;
		private int state_cf;
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getState_code() {
			return state_code;
		}
		public void setState_code(String state_code) {
			this.state_code = state_code;
		}
		public int getState_cf() {
			return state_cf;
		}
		public void setState_cf(int state_cf) {
			this.state_cf = state_cf;
		}
	}
	
	public static class CityData {
		private String city, postal_code, area_code;
		private int time_zone, city_cf;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostal_code() {
			return postal_code;
		}
		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
		}
		public String getArea_code() {
			return area_code;
		}
		public void setArea_code(String area_code) {
			this.area_code = area_code;
		}
		public int getTime_zone() {
			return time_zone;
		}
		public void setTime_zone(int time_zone) {
			this.time_zone = time_zone;
		}
		public int getCity_cf() {
			return city_cf;
		}
		public void setCity_cf(int city_cf) {
			this.city_cf = city_cf;
		}
		
	}
}
