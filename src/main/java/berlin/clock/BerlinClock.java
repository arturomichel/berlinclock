package berlin.clock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BerlinClock {

	private String time;
	
	private String hours20;
	
	private String hours1;
	
	private String min5;
	
	private String min1;
	
	private String sec;
	

	public BerlinClock() {
		super();
	}

	public BerlinClock(String time, String hours20, String hours1, String min5, String min1, String sec) {
		super();
		this.time = time;
		this.hours20 = hours20;
		this.hours1 = hours1;
		this.min5 = min5;
		this.min1 = min1;
		this.sec = sec;
	}

	public BerlinClock(String time){
		this(time, null, null, null, null, null);
	}



	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getHours20() {
		return hours20;
	}


	public void setHours20(String hours20) {
		this.hours20 = hours20;
	}


	public String getHours1() {
		return hours1;
	}


	public void setHours1(String hours1) {
		this.hours1 = hours1;
	}


	public String getMin5() {
		return min5;
	}


	public void setMin5(String min5) {
		this.min5 = min5;
	}


	public String getMin1() {
		return min1;
	}


	public void setMin1(String min1) {
		this.min1 = min1;
	}


	public String getSec() {
		return sec;
	}


	public void setSec(String sec) {
		this.sec = sec;
	}

	@Override
	public String toString() {
		return "BerlinHeuer [time=" + time + ", hours20=" + hours20 + ", hours1=" + hours1 + ", min5=" + min5 + ", min1=" + min1 + ", sec=" + sec + "]";
	}

	
}
