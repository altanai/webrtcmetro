package com.tcs.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Geolocation")
public class geolocation {
String sipuri;
String latitude;
String longitude;
String date;
String time;
String friendName;


public geolocation(String sipuri, String latitude, String longitude,
		String date, String time) {
	super();
	this.sipuri = sipuri;
	this.latitude = latitude;
	this.longitude = longitude;
	this.date = date;
	this.time = time;
	
}
public geolocation() {
	// TODO Auto-generated constructor stub
}

@Id
@GeneratedValue
@Column(name="sipuri")	
public String getSipuri() {
	return sipuri;
}
public void setSipuri(String sipuri) {
	this.sipuri = sipuri;
}


@Column(name="latitude")	
public String getLatitude() {
	return latitude;
}
public void setLatitude(String latitude) {
	this.latitude = latitude;
}

@Column(name="longitude")	
public String getLongitude() {
	return longitude;
}
public void setLongitude(String longitude) {
	this.longitude = longitude;
}

@Column(name="date")	
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

@Column(name="time")	
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

@Column(name="friendname")	
public String getFriendName() {
	return friendName;
}
public void setFriendName(String friendName) {
	this.friendName = friendName;
}


}
