package de.olli.ycsb.configgenerator.examples;

import de.olli.ycsb.configgenerator.generator.Config;
import de.olli.ycsb.configgenerator.generator.Phase;
import de.olli.ycsb.configgenerator.generator.extensions.GangliaExtension;
import de.olli.ycsb.configgenerator.generator.extensions.VeryHotspotExtension;

public class WorkloadTests2012 {
	
	public static void main(String[] args) {
		
		int baseWorkloadOps = Integer.parseInt(args[0]);
		int baseWorkloadTarget = Integer.parseInt(args[1]);
		int scenario = Integer.parseInt(args[2]);
		double writeRatio = Double.parseDouble(args[3]);
		
		if(writeRatio < 0 || writeRatio > 1) {
			System.err.print("Write ratio must be in between 0 and 1");
			return;
		}
		
		double readRatio =  1d - writeRatio;
		
		String scenarioName = "";
		int hotspots;
		double variance;
		double alpha;
		double peakWorkloadFactor;
		double increaseToPeak;
		
		
		switch(scenario) {
			case 1:
				scenarioName = "EECS Photos";
				hotspots = 50;
				alpha = 0d;
				variance = 0d;
				peakWorkloadFactor = 2.43;
				increaseToPeak = 25.4/100;
				break;
			case 2:
				scenarioName = "WorldCup";
				hotspots = 159;
				alpha = 0.8;
				variance = 0.0005;
				peakWorkloadFactor = 4.97;
				increaseToPeak = 8.7/100;
				break;
			default:
				System.err.println("wrong scenario number");
				return;
		}
		
//		int peakWorkloadOps = (int) (baseWorkloadOps * peakWorkloadFactor);
//		int peakWorkloadTarget = (int) (baseWorkloadTarget * peakWorkloadFactor);
		int phasesToPeak = (int) (Math.ceil(peakWorkloadFactor / increaseToPeak));
		
		Config c = new Config("Hotspot workload - scenario: "+scenarioName);
		
		Phase p = new Phase(0);
		p.setDebug("no");
		p.setHosts("127.0.0.1");
		p.setInsertorder("ordered");
		p.setLoad("no");
		p.setReadallfields("true");
		p.setReadproportion(""+readRatio);
		p.setScanproportion("0");
		p.setUpdateproportion("0");
		p.setInsertproportion(""+writeRatio);
		p.setWorkload("com.yahoo.ycsb.workloads.HotspotWorkload");
		p.setRequestdistribution("veryhotspot");
		p.setRecordcount("4000000");
		p.setThreadcount(""+40);
		
		VeryHotspotExtension ext = new VeryHotspotExtension(0);
		ext.setChartPath("/home/ubuntu");
		ext.setHotspots(""+hotspots);
		ext.setVariance(""+variance);
		ext.setAlpha(""+alpha);
		p.addExtension(ext);
		
		GangliaExtension gext = new GangliaExtension(0);
		gext.setReporter("com.yahoo.ycsb.measurements.reporter.GMetricReporter");
		gext.setGmetricGmondaddress("localhost");
		gext.setGmetricPort("8649");
		p.addExtension(gext);
		
		c.setPhaseIndependent(p);
		
		
		for(int i=1;i<=phasesToPeak;i++) {
			int opsCount = i * (int) (increaseToPeak * baseWorkloadOps);
			int targetCount = i * (int) (increaseToPeak * baseWorkloadTarget);
			
			p = new Phase(i);
			p.setOperationcount(opsCount+"");
			p.setTarget(targetCount+"");
			if(i==phasesToPeak) {
				p.setOperationcount(opsCount*5+"");
			}
			c.addPhase(p);
		}
		
		System.out.println(c.toConfigString());
		 
		
	}

}
