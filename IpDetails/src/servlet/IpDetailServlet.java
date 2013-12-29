package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import data.IpDataHelper;

import util.IpUtil;
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
				IpDataHelper.populateIpError(displayBean);
			} else {
				displayBean = IpDataHelper.getIpDisplayBean(ipAddress);
			}

		} catch (Exception e) {
			//show general error msg
			IpDataHelper.populateGeneralErrorMsg(displayBean);
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
