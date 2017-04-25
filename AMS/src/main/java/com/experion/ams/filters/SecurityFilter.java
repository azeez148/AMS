package com.experion.ams.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(final FilterConfig arg0) throws ServletException {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		final HttpSession session = ((HttpServletRequest) request)
				.getSession(false);
		final String contextName = ((HttpServletRequest) request)
				.getContextPath();
		final String requestURI = ((HttpServletRequest) request)
				.getRequestURI();
		final boolean dtoInSession = session != null
				&& session.getAttribute("empDetails") != null
				&& session.getAttribute("empCode") != null;
		if ((dtoInSession || requestURI.startsWith(contextName + "/login")
				|| requestURI.endsWith(".css") || requestURI.endsWith(".gif")
				|| requestURI.endsWith(".jpg")
				|| requestURI.endsWith("index.jsp")
				|| requestURI.endsWith("error.jsp")
				|| requestURI.endsWith(".jsp") || requestURI.endsWith(".js")
				|| requestURI.endsWith(".pdf") || requestURI.endsWith(".jpeg")
				|| requestURI.endsWith(".png") || requestURI.equals(contextName
				+ "/"))
				&& (!requestURI.endsWith("/home"))
				|| requestURI.startsWith(contextName + "/rest")) {
			chain.doFilter(request, response);
		} else if (dtoInSession && requestURI.endsWith("/home")) {
			chain.doFilter(request, response);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// do nothing
	}

}