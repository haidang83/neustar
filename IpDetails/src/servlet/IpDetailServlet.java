package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import util.IpUtil;
import view.IpDataViewHelper;
import webService.IpDetailService;
import bean.GeoPointResponseBean;
import bean.IpDataDisplayBean;

/**
 * Servlet implementation class showIpDetails
 */
@WebServlet("/")
public class IpDetailServlet extends HttpServlet {
	private static final String IP_DETAILS_JSP_NAME = "/ipDetails.jsp";
	private static final String IP_BEAN_ATTR_NAME = "ipBean";
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(IpDetailServlet.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
								HttpServletResponse response) throws ServletException, IOException{
        
		IpDataDisplayBean displayBean = new IpDataDisplayBean();
		try {
			String ipAddress = IpUtil.getClientIpAddr(request);

			if (!IpUtil.isValidIpAddr(ipAddress)) {
				// display error
				log.error("invalid ipAddr: " + ipAddress);
				IpDataViewHelper.populateIpError(displayBean);
			} else {
				//GeoPointResponseBean ipData = IpDetailService.getIpData(ipAddress);
				//IpDataViewHelper.populateIpData(ipData, displayBean);
				//displayBean.setIpAddr(ipAddress);
				
				displayBean = IpDataViewHelper.getIpDisplayBean(ipAddress);
			}

		} catch (Exception e) {
			//show general error msg
			IpDataViewHelper.populateGeneralErrorMsg(displayBean);
			log.error("Exception caught in IpDetailServlet", e);
		}
        request.setAttribute(IP_BEAN_ATTR_NAME, displayBean);
        RequestDispatcher rd=request.getRequestDispatcher(IP_DETAILS_JSP_NAME);
        rd.forward(request,response);
        
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
