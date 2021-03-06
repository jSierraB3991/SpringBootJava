package com.example.exampletwilio.model;

public class ReturnOk 
{
	private String ssid;

	public ReturnOk(String sid) 
	{
		this.ssid = sid;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
}
