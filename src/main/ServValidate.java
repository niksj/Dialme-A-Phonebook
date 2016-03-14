package main;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@WebServlet("/servvalidate")
public class ServValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServValidate() {
        // Auto-generated constructor
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	String text = "";
    	String number = request.getParameter("number");
    	String country = request.getParameter("code");
    	PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
    	try {
    		PhoneNumber phoneNumber;
    		if(number.startsWith("+")) {
    			phoneNumber = phoneUtil.parse(number,"");
    		}
    		else {
    			phoneNumber = phoneUtil.parse(number, country);
    		}
    		  if(phoneUtil.isValidNumber(phoneNumber)) {
    			  text = phoneUtil.format(phoneNumber, PhoneNumberFormat.E164);
    		  }else {
    			  text = "error";
    		  }
    		} catch (NumberParseException e) {
    		  System.err.println("NumberParseException was thrown: " + e.toString());
    		  text = "error";
    		}
        response.setContentType("text/plain");  
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(text);  
        
    }

}
