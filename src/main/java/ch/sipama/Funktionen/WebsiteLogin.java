package ch.sipama.Funktionen;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;



public class WebsiteLogin {
	public static void main(String args[]) throws Exception {  

		HttpClient client = new HttpClient();  
		client.getParams().setParameter("vb_login_username", "Programmierklasse");  
		client.getParams().setParameter("vb_login_password", "987654");

		GetMethod method = new GetMethod("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!:8080/");  
		try{  
			client.executeMethod(method);  
			Cookie[] cookies = client.getState().getCookies();  
			for (int i = 0; i < cookies.length; i++) {  
				Cookie cookie = cookies[i];  
				System.err.println(  
						"Cookie: " + cookie.getName() +  
						", Value: " + cookie.getValue() +  
						", IsPersistent?: " + cookie.isPersistent() +  
						", Expiry Date: " + cookie.getExpiryDate() +  
						", Comment: " + cookie.getComment());  
			}  
			client.executeMethod(method);  
		} catch(Exception e) {  
			System.err.println(e);  
		} finally {  
			method.releaseConnection();  
		}  
	}  
}