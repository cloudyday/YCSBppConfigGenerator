package de.olli.ycsb.configgenerator.generator;

public abstract class Extension {
	
	protected int phase;
	
	/**
	 * 
	 * @param phase Set this to 0 if you want to have this as a phase independent extension
	 */
	public Extension(int phase) {
		this.phase = phase;
	}
	
	public abstract String toConfigString();
	

}
