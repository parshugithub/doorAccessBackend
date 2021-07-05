package com.ncs.doorsystem.config;


public abstract class MQTTConfig {

	protected final String broker = "iot.eclipse.org";
	protected final int qos = 1;
	protected Boolean hasSSL = false; /* By default SSL is disabled */
	protected Integer port = 1883; /* Default port */
	protected final String userName = "testUserName";
	protected final String password = "demoPassword";
	public final String TCP = "tcp://192.168.0.198:1883";
	public final String clientIp ="192.168.0.198";
	//private final String TCPclient = "tcp://192.168.0.200:1883";
	protected final String SSL = "ssl://";

	/**
	 * Custom Configuration
	 * 
	 * @param broker
	 * @param port
	 * @param ssl
	 * @param withUserNamePass
	 */
	protected abstract void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass);

	/**
	 * Default Configuration
	 */
	protected abstract void config();

//	public String getTCPclient() {
//		return TCPclient;
//	}

	
	
}
