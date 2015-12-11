package fr.iutvalence.info.dut.m3105.preamble.copy;

public class TrafficSignal extends Thread implements TrafficSignalInterface
{
	private final static int BUTTON_THRESHOLD_IN_SECONDS = 2;
	
	private TrafficSignalState state;

	
	public TrafficSignal()
	{
		super();
		this.switchToState(TrafficSignalState.GREEN);
	}
	
	public void setState(TrafficSignalState state){
		this.state=state;
	}
	
	@Override
	public void tick()
	{
		this.state.tick(this);
	}

	@Override
	public void buttonPressed()
	{
		System.out.println("Button pressed!");
		System.out.flush();
		this.state.buttonPressed(this);
		
	}
		
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(1000);
				this.secondEllapsed();
			}
			catch (InterruptedException e)
			{
				break;
			}
		}
	}

	private void secondEllapsed()
	{
		this.stateSecondsRemaining--;
		System.out.println(this.stateSecondsRemaining);
		System.out.flush();
		if (this.stateSecondsRemaining == 0)
		{
			switch(this.state)
			{
				case GREEN: 
					this.switchToState(TrafficSignalState.ORANGE);
					break;
				case ORANGE: 
					this.switchToState(TrafficSignalState.RED);
					break;
				case RED: 
					this.switchToState(TrafficSignalState.GREEN);
					break;
			}
		}	
	}

	private void switchToState(TrafficSignalState state)
	{
		System.out.println("Traffic signal turns "+state);
		System.out.flush();
		this.state = state;
		this.stateSecondsRemaining = this.state.getDurationInSeconds();		
	}


}
