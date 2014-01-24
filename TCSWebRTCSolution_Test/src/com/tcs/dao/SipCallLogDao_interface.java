package com.tcs.dao;

import com.tcs.bean.CallLogs;
import com.tcs.bean.Login;

public interface SipCallLogDao_interface {
	public int addCallDetails(CallLogs callLog) ;
	public CallLogs viewAllLogs(Login user);
	public int getNoOfRecords(Login user);
	
}
