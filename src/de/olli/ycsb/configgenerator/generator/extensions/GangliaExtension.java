package de.olli.ycsb.configgenerator.generator.extensions;

import de.olli.ycsb.configgenerator.generator.Extension;

public class GangliaExtension extends Extension {
	

	private String reporter;
	private String gmetricGmondaddress;
	private String gmetricPort;
	
	public GangliaExtension(int phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toConfigString() {
		String configString = "\n";
		
		if(phase == 0) {
			if(reporter != null) {
				configString = configString + "reporter="+reporter+"\n";
			}
			if(gmetricGmondaddress != null) {
				configString = configString + "gmetric.gmondaddress="+gmetricGmondaddress+"\n";
			}
			if(gmetricPort != null) {
				configString = configString + "gmetric.port="+gmetricPort+"\n";
			}
			
		}
		
		
		
		return configString;
	}


	public String getReporter() {
		return reporter;
	}


	public void setReporter(String reporter) {
		this.reporter = reporter;
	}


	public String getGmetricGmondaddress() {
		return gmetricGmondaddress;
	}


	public void setGmetricGmondaddress(String gmetricGmondaddress) {
		this.gmetricGmondaddress = gmetricGmondaddress;
	}


	public String getGmetricPort() {
		return gmetricPort;
	}


	public void setGmetricPort(String gmetricPort) {
		this.gmetricPort = gmetricPort;
	}
	

	

	
	

}
