
public class TV {
	private boolean state;
	
	private int channel;
	
	private int volume;
	
	public static final int VOLUME_MAX = 100;
	
	public static final int VOLUME_MIN = 0;
	
	public static final int CHANNEL_MIN = 0;
	
	public static final int CHANNEL_MAX = 100;
	
	public TV()
	{
		this(true, 30, 50);
	}
	
	public TV(boolean newState, int newChannel, int newVolume)
	{
		state = newState;
		this.changeChannel(newChannel);
		this.changeVolume(newVolume);
	}
	
	public TV(int newChannel)
	{
		this(true, 30, newChannel);
	}
	
	public TV(int newChannel, int newVolume)
	{
		this(true, newChannel, newVolume);
	}
	
	public void changeChannel(int channelNumber)
	{
		if (channelNumber <= CHANNEL_MAX)
		{
			if (channelNumber >= CHANNEL_MIN)
			{
				channel = channelNumber;
			} else
			{
				channel = CHANNEL_MIN;
			}
		} else
		{
			channel = CHANNEL_MAX;
		}
	}
	
	public void changeVolume(int volumeNumber)
	{
		if (volumeNumber <= VOLUME_MAX)
		{
			if (volumeNumber >= VOLUME_MIN)
			{
				volume = volumeNumber;
			} else 
			{
				volume = VOLUME_MIN;
			}
		} else
		{
			volume = VOLUME_MAX;
		}
	}
	
	public void turnOff()
	{
		state = false;
	}
	
	public void turnOn()
	{
		state = true;
	}
	
	public void volumeDown()
	{
		if (this.volume > VOLUME_MIN)
			{
				volume = this.volume - 1;
			}
	}
	
	public void volumeUp()
	{
		if (this.volume < VOLUME_MAX)
		{
			volume = this.volume + 1;
		}
	}
	
	public void channelUp()
	{
		if (this.channel < CHANNEL_MAX)
		{
			channel = this.channel + 1;
		} else
		{
			channel = CHANNEL_MIN;
		}
	}
	
	public void channelDown()
	{
		if (this.channel > CHANNEL_MIN)
		{
			channel = this.channel - 1;
		} else
		{
			channel = CHANNEL_MAX;
		}
	}
	
	public int getChannel()
	{
		return channel;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	public boolean getState()
	{
		return state;
	}
	
	public void togglePower()
	{
		state = !state;
	}
}
