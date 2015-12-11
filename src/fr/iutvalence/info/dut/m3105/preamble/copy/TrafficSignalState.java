package fr.iutvalence.info.dut.m3105.preamble.copy;

public abstract class TrafficSignalState
{
	protected final int durationInSeconds;
	protected int stateSecondsRemaining; 
	
	public TrafficSignalState(int durationInSeconds)
	{
		this.durationInSeconds = durationInSeconds;
	}
	
	public int getDurationInSeconds()
	{
		return this.durationInSeconds;
	}
	
	public abstract void tick(TrafficSignal ts);
	public abstract void buttonPressed(TrafficSignal ts);
}
