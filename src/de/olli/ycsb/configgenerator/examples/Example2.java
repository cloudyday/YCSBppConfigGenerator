package de.olli.ycsb.configgenerator.examples;

import de.olli.ycsb.configgenerator.generator.Config;
import de.olli.ycsb.configgenerator.generator.Phase;
import de.olli.ycsb.configgenerator.generator.extensions.GangliaExtension;
import de.olli.ycsb.configgenerator.generator.extensions.VeryHotspotExtension;

public class Example2 {
	
	public static void main(String[] args) {
		
		int peakWorkloadThreads = 180;
		int workloadOps = 10000000;
		
		int phasesToPeak = 10;
		
		Config c = new Config("Inserted: ordered, run: hashed, 99/1, uniform");
		
		Phase p = new Phase(0);
		p.setDebug("no");
		p.setHosts("10.83.69.237,10.202.205.123,10.85.11.165,10.34.101.178,10.39.121.176,10.118.31.151,10.98.107.48,10.76.215.97,10.76.205.48");
		p.setInsertproportion("0.01");
		p.setLoad("no");
		p.setReadallfields("true");
		p.setReadproportion("0.99");
		p.setScanproportion("0");
		p.setUpdateproportion("0");
		p.setWorkload("com.yahoo.ycsb.workloads.CoreWorkload");
		p.setRequestdistribution("uniform");
		p.setRecordcount("180000000");
		

		
		GangliaExtension gext = new GangliaExtension(0);
		gext.setReporter("com.yahoo.ycsb.measurements.reporter.GMetricReporter");
		gext.setGmetricGmondaddress("localhost");
		gext.setGmetricPort("8649");
		p.addExtension(gext);
		
		c.setPhaseIndependent(p);
		
		for(int i=1;i<=phasesToPeak;i++) {
			int opsCount = workloadOps;
			int threadCount = i * (peakWorkloadThreads / phasesToPeak);
			
			p = new Phase(i);
			p.setThreadcount(threadCount+"");

			c.addPhase(p);
		}
		

		
		String configString = c.toConfigString();
		System.out.println(configString);
		
		
		
		
	}

}
