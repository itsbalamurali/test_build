package com.chatak.pg.util.validator;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class CrossScriptingFilter implements Filter {
  private static Logger logger = Logger.getLogger(CrossScriptingFilter.class);

  private FilterConfig filterConfig;

  public FilterConfig getFilterConfig() {
    return filterConfig;
  }

  public void setFilterConfig(FilterConfig filterConfig) {
    this.filterConfig = filterConfig;
  }

  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }

  public void destroy() {
    this.filterConfig = null;
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                            ServletException {
    logger.debug("Inlter CrossScriptingFilter  ...............");
    chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
    logger.debug("Outlter CrossScriptingFilter ...............");
  }

}
