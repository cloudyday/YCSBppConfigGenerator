package de.olli.ycsb.configgenerator.generator;

import java.util.LinkedList;
import java.util.List;

public class Phase {
	
	private int index;
	
	private String hosts;
	
	private String recordcount;
	private String operationcount;
	private String threadcount;
	private String target;
	private String workload;
	private String requestdistribution;
	
	private String debug;
	
	private String insertorder;
	private String load;
	private String readallfields;

	private String readproportion;
	private String updateproportion;
	private String scanproportion;
	private String insertproportion;
	
	private List<Extension> extensions;
	
	public Phase(int index) {
		this.index = index;
		extensions = new LinkedList<Extension>();
	}
	
	public String toConfigString() {
		String configString ="\n\n";
		
		if(index==0) {
			configString = configString + "#### PHASE INDEPENDENT SETTINGS ####\n\n";
		} else {
			configString = configString + "####### PHASE "+index+" #######\n\n";
		}

		
		if(hosts != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "hosts="+hosts+"\n";
		}
		if(recordcount != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "recordcount="+recordcount+"\n";
		}
		if(operationcount != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "operationcount="+operationcount+"\n";
		}
		if(threadcount != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "threadcount="+threadcount+"\n";
		}
		if(target != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "target="+target+"\n";
		}
		if(workload != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "workload="+workload+"\n";
		}
		if(requestdistribution != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "requestdistribution="+requestdistribution+"\n";
		}
		
		if(debug != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "debug="+debug+"\n";
		}
		
		if(insertorder != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "insertorder="+insertorder+"\n";
		}
		if(load != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "load="+load+"\n";
		}
		if(readallfields != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "readallfields="+readallfields+"\n";
		}
		
		if(readproportion != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "readproportion="+readproportion+"\n";
		}
		if(updateproportion != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "updateproportion="+updateproportion+"\n";
		}
		if(scanproportion != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "scanproportion="+scanproportion+"\n";
		}
		if(insertproportion != null) {
			configString = configString + (index != 0 ? "phase"+index+".":"") + "insertproportion="+insertproportion+"\n";
		}
		
		for(Extension ext : extensions) {
			configString = configString + ext.toConfigString();
		}
		
		return configString;
	}
	
	public String getHosts() {
		return hosts;
	}
	public void setHosts(String hosts) {
		this.hosts = hosts;
	}
	public String getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(String recordcount) {
		this.recordcount = recordcount;
	}
	public String getOperationcount() {
		return operationcount;
	}
	public void setOperationcount(String operationcount) {
		this.operationcount = operationcount;
	}
	public String getThreadcount() {
		return threadcount;
	}
	public void setThreadcount(String threadcount) {
		this.threadcount = threadcount;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
	}
	public String getRequestdistribution() {
		return requestdistribution;
	}
	public void setRequestdistribution(String requestdistribution) {
		this.requestdistribution = requestdistribution;
	}
	public String getDebug() {
		return debug;
	}
	public void setDebug(String debug) {
		this.debug = debug;
	}
	public String getInsertorder() {
		return insertorder;
	}
	public void setInsertorder(String insertorder) {
		this.insertorder = insertorder;
	}
	public String getLoad() {
		return load;
	}
	public void setLoad(String load) {
		this.load = load;
	}
	public String getReadallfields() {
		return readallfields;
	}
	public void setReadallfields(String readallfields) {
		this.readallfields = readallfields;
	}
	public String getReadproportion() {
		return readproportion;
	}
	public void setReadproportion(String readproportion) {
		this.readproportion = readproportion;
	}
	public String getUpdateproportion() {
		return updateproportion;
	}
	public void setUpdateproportion(String updateproportion) {
		this.updateproportion = updateproportion;
	}
	public String getScanproportion() {
		return scanproportion;
	}
	public void setScanproportion(String scanproportion) {
		this.scanproportion = scanproportion;
	}
	public String getInsertproportion() {
		return insertproportion;
	}
	public void setInsertproportion(String insertproportion) {
		this.insertproportion = insertproportion;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
	}
	
	public void addExtension(Extension ext) {
		extensions.add(ext);
	}
	
	
	
}
