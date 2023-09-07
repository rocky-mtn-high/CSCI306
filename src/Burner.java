//Rachel Castro
public class Burner {
	//members
	public enum Temperature {
		BLAZING, HOT, WARM, COLD
	}
	
	private Temperature myTemperature; 
	
	private Setting mySetting;
	
	private int timer; 
	
	public static final int TIME_DURATION = 2; 
	
	
	
	//getters/setters
	public Temperature getTemperature() {
		return myTemperature; 
	}
	
	//constructors
	public Burner(){
		mySetting = Setting.OFF;
		myTemperature = Temperature.COLD; 
		timer = TIME_DURATION;
	}
	
	//methods
	
	//raises the setting one notch
	public void plusButton() {
		switch(mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM; 
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			mySetting = Setting.HIGH;
			break; 
		}
		timer = TIME_DURATION; 
		return;
	}
	
	//lowers the setting one notch
	public void minusButton() {
		switch(mySetting) {
		case OFF:
			mySetting = Setting.OFF;
			break;
		case LOW:
			mySetting = Setting.OFF; 
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break; 
		}
		timer = TIME_DURATION; 
		return;
	}
	
	//called to update the burner every minute
	private void updateTemperature() {
		//timer update
		timer--;
		//temperature update
		if (timer == 0) {
			//increase temperature by 1
			switch(myTemperature) {
				case COLD:
					myTemperature = Temperature.WARM;
				case WARM:
					myTemperature = Temperature.HOT;
				case HOT:
					myTemperature = Temperature.BLAZING;
				case BLAZING:
					myTemperature = Temperature.BLAZING;
			}
		}
		return; 
	}
	
	
	//Show the status of the burner
	public void display() {
		String stoveOut;
		if (myTemperature == Temperature.COLD) {
			stoveOut = "coooool";
		} else if (myTemperature == Temperature.WARM) {
			stoveOut = "warm";
		} else if (myTemperature == Temperature.HOT) {
			stoveOut = "CAREFUL";
		} else if (myTemperature == Temperature.BLAZING) {
			stoveOut = "VERY HOT! DON'T TOUCH";
		}
		
		String finalOut = "[" + mySetting.toString() + "] ..... " + stoveOut; 
		System.out.println(finalOut);
		
		if (myTemperature == Temperature.BLAZING) {
			System.out.println("RED LIGHT - HOT BURNER ALERT"); 
		}
		
	}
	
	//returns blazing status
	public boolean isBlazing() {
		if (myTemperature == Temperature.BLAZING) {
			return true;
		}
		return false; 
	}

}
