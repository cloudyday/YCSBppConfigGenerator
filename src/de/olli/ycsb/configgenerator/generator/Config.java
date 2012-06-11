package de.olli.ycsb.configgenerator.generator;

import java.util.LinkedList;
import java.util.List;

public class Config {
	
	private String name;
	private Phase phaseIndependent;
	private List<Phase> phases;
	

	public Config(String name) {
		this.name = name;
		phases = new LinkedList<Phase>();
	}


	public String toConfigString() {
		String configString = "###########################################################" +
				"\n############ YCSB config ##################################" +
				"\n############ Name: "+ name+"" +
						"\n###########################################################";
		configString = configString + phaseIndependent.toConfigString();
		

		if(!phases.isEmpty()) {
			configString = configString + "\n\n" +
					"phases="+phases.size()+"\n";
		}
		for(Phase p : phases) {
			configString = configString + p.toConfigString();
		}

		
		configString = configString + "\n\n" +
				"######### END OF YCSB CONFIG ##########";	
		
		return configString;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Phase getPhaseIndependent() {
		return phaseIndependent;
	}



	public void setPhaseIndependent(Phase phaseIndependent) {
		this.phaseIndependent = phaseIndependent;
	}



	public List<Phase> getPhases() {
		return phases;
	}



	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}
	
	public void addPhase(Phase p) {
		phases.add(p);
	}



	

}
