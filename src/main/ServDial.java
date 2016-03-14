package main;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * Servlet implementation class ServDial
 */
@WebServlet("/servdial")
public class ServDial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServDial() {
        super();
        // Auto-generated constructor 
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("fullNumber");
		response.sendRedirect("http://webrtc.lumicall.org/?dial=" + number);
	}

}
