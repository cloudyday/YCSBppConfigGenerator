package de.olli.ycsb.configgenerator.examples;

import de.olli.ycsb.configgenerator.generator.Config;
import de.olli.ycsb.configgenerator.generator.Phase;
import de.olli.ycsb.configgenerator.generator.extensions.GangliaExtension;
import de.olli.ycsb.configgenerator.generator.extensions.VeryHotspotExtension;

public class Example1 {
	
	public static void main(String[] args) {
		
		Config c = new Config("Test");
		
		Phase p = new Phase(0);
		p.setDebug("no");
		p.setHosts("127.0.0.1");
		p.setInsertorder("ordered");
		p.setInsertproportion("0");
		p.setLoad("no");
		p.setReadallfields("true");
		p.setReadproportion("1.0");
		p.setScanproportion("0");
		p.setUpdateproportion("0");
		p.setWorkload("com.yahoo.ycsb.workloads.HotspotWorkload");
		p.setRequestdistribution("veryhotspot");
		p.setRecordcount("20000000");
		

		
		GangliaExtension gext = new GangliaExtension(0);
		gext.setReporter("com.yahoo.ycsb.measurements.reporter.GMetricReporter");
		gext.setGmetricGmondaddress("localhost");
		gext.setGmetricPort("8649");
		p.addExtension(gext);
		
		c.setPhaseIndependent(p);
		
		p = new Phase(1);
		p.setOperationcount("10000");
		p.setThreadcount("20");
		
		VeryHotspotExtension ext = new VeryHotspotExtension(0);
		ext.setChartPath("/home/ubuntu");
		ext.setHotspots("150");
		ext.setVariance("0.0001");
		ext.setAlpha("1");
		p.addExtension(ext);
		
		c.addPhase(p);
		
		String configString = c.toConfigString();
		System.out.println(configString);
		
		
		
		
	}

}
