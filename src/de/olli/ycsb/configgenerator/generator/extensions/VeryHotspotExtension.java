package de.olli.ycsb.configgenerator.generator.extensions;

import de.olli.ycsb.configgenerator.generator.Extension;

public class VeryHotspotExtension extends Extension {
	

	private String chartPath;
	private String hotspots;
	private String variance;
	private String alpha;
	
	public VeryHotspotExtension(int phase) {
		super(phase);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toConfigString() {
		String configString = "\n";
		
		configString = configString + "chartPath="+chartPath+"\n";
		
		configString = configString + (phase != 0 ? "phase"+phase+".":"") + "index="+phase+"\n";

		if(hotspots != null) {
			configString = configString + (phase != 0 ? "phase"+phase+".":"") + "hotspots="+hotspots+"\n";
		}
		if(variance != null) {
			configString = configString + (phase != 0 ? "phase"+phase+".":"") + "variance="+variance+"\n";
		}
		if(alpha != null) {
			configString = configString + (phase != 0 ? "phase"+phase+".":"") + "alpha="+alpha+"\n";
		}
		
		return configString;
	}
	
	public String getHotspots() {
		return hotspots;
	}
	public void setHotspots(String hotspots) {
		this.hotspots = hotspots;
	}
	public String getVariance() {
		return variance;
	}
	public void setVariance(String variance) {
		this.variance = variance;
	}
	public String getAlpha() {
		return alpha;
	}
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}

	public String getChartPath() {
		return chartPath;
	}

	public void setChartPath(String chartPath) {
		this.chartPath = chartPath;
	}
	

	
	

}
