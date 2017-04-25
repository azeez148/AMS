package com.experion.ams.mvc.controller.pmo;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.impl.auth.NTLMScheme;

/**
 * 
 */

/**
 * @author Aneesh Chandran
 *
 */
public class PMONTLMSchemeFactory implements AuthSchemeFactory {

	@Override
	public AuthScheme newInstance(org.apache.http.params.HttpParams arg0) {
		return new NTLMScheme(new JCIFSEngine());
	}
	/*
	public String authenticate(String userName, String password, String domain, String workStation){
		
	}
*/
}
