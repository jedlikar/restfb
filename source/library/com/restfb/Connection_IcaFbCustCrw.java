package com.restfb;


public class Connection_IcaFbCustCrw<T> extends Connection<T> {

	public Connection_IcaFbCustCrw(FacebookClient facebookClient, String json,
			Class<T> connectionType) {
		super(facebookClient, json, connectionType);
	}
	
	public Connection_IcaFbCustCrw<T> fetchNextPage() {
		return (Connection_IcaFbCustCrw<T>) super.fetchNextPage();
	  }

}
