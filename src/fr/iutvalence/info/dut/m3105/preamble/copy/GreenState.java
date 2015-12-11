package fr.iutvalence.info.dut.m3105.preamble.copy;

public class GreenState extends TrafficSignalState
{
	private static final int TIME_OUT=10; 
	public GreenState(){
		super(TIME_OUT);
	}

	@Override
	public void tick(TrafficSignal ts)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buttonPressed(TrafficSignal ts)
	{
		if (this.stateSecondsRemaining > BUTTON_THRESHOLD_IN_SECONDS)
			this.stateSecondsRemaining = BUTTON_THRESHOLD_IN_SECONDS;					
	}
	
}
