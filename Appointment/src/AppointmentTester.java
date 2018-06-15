
public class AppointmentTester {

	public static void main(String[] args) {
		Appointment myAppointment = new Appointment(8, 5, 8, 45, "My Appointment");
		//Appointment yourAppointment = new Appointment(-9, 9, -3, 10, "Your Appointment");
		Appointment appointment = new Appointment(8, 0, 9, 20, "His Appointment");
		
		System.out.println(appointment.overlap(myAppointment));
	}

}
