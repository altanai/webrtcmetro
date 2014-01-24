package com.tcs.dao;

import com.tcs.bean.openLinkBean;

public interface OpenLinkDao_interface {
	public int addthirdpartyaccountDetails(openLinkBean tpa) ;
	public openLinkBean getAccountDetails(String sipUri);
}
