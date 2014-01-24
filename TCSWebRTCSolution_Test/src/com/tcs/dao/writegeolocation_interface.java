package com.tcs.dao;

import java.util.ArrayList;

import com.tcs.bean.geolocation;

public interface writegeolocation_interface {
	public ArrayList<geolocation> viewgeolocationDetails(String user) ;
	public int addgeolocationDetails(geolocation g) ;
	public int removeLoc(String sipUri);
	
}
