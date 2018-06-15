
public class TVTester {

	public static void main(String[] args) {
		TV myTV = new TV(true, 3, 100);
		System.out.println(myTV.getChannel());
		System.out.println(myTV.getVolume());
		System.out.println(myTV.getState());
		myTV.changeChannel(0);
		myTV.changeVolume(0);
		myTV.turnOff();
		System.out.println("=========================");
		System.out.println(myTV.getChannel());
		System.out.println(myTV.getVolume());
		System.out.println(myTV.getState());
		myTV.togglePower();
		System.out.println("=========================");
		System.out.println(myTV.getChannel());
		System.out.println(myTV.getVolume());
		System.out.println(myTV.getState());
		myTV.volumeDown();
		System.out.println("=========================");
		System.out.println(myTV.getVolume());
		myTV.channelDown();
		System.out.println("=========================");
		System.out.println(myTV.getChannel());
		myTV.volumeUp();
		System.out.println("=========================");
		System.out.println(myTV.getVolume());
	}

}
