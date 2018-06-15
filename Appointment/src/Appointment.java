public class Appointment {
	
	//private int startHourTime;
	
	//private int startMinuteTime;
	
	//private int endHourTime;
	
	//private int endMinuteTime;
	
	private int initialStartTime;
	
	private int initialEndTime;
	
	private String nameOfAppointment;
	
	public static final int HOUR_CONVERSION = 60;
	
	public Appointment(int startHour, int startMinute, int endHour, int endMinute, String appointmentName)
	{
		initialStartTime = startHour * Appointment.HOUR_CONVERSION + startMinute;
		initialEndTime = endHour * Appointment.HOUR_CONVERSION + endMinute;
		if ((initialEndTime < initialStartTime) || ((startHour < 0 || startHour > 24) || (endHour < 0 || endHour > 24)) || ((startMinute < 0 && startMinute > 60) || (endMinute < 0 && endMinute > 60)))
		{
			System.out.println("ERROR");
			initialStartTime = 0;
			initialEndTime = 60;
		}
		nameOfAppointment = appointmentName;
		//if ((startHour >= 0 && startHour < 24) && (endHour >= 0 && endHour < 24) && (startMinute >= 0 && startMinute < 60) && (endMinute >= 0 && endMinute < 60) && ((endHour > startHour) || (endHour == startHour && endMinute >= startMinute)))
		//{
		//	startHourTime = startHour;
		//	startMinuteTime = startMinute;
		//	endHourTime = endHour;
		//	endMinuteTime = endMinute;
		//} else
		//{
		//	System.out.println("ERROR");
		//	startHourTime = 0;
		//	startMinuteTime = 0;
		//	endHourTime = 10;
		//	endMinuteTime = 10;
		//}
		//nameOfAppointment = appointmentName;
	}
	
	public boolean overlap(Appointment otherAppointment)
	{	
		return (this.initialEndTime >= otherAppointment.initialStartTime && this.initialStartTime <= otherAppointment.initialEndTime);
	}
	
}