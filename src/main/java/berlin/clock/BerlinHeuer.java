package berlin.clock;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BerlinHeuer {

	private String time;
	
	private String berlin;
	
	private boolean provided;

	public BerlinHeuer() {
		super();
	}

	public BerlinHeuer(String time, String berlin, boolean provided) {
		this.time = time;
		this.berlin = berlin;
		this.provided = provided;
	}

	public BerlinHeuer(String time, String berlin) {
		this.time = time;
		this.berlin = berlin;
		this.provided = false;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBerlin() {
		return berlin;
	}

	public void setBerlin(String berlin) {
		this.berlin = berlin;
	}

	public boolean isProvided() {
		return provided;
	}

	public void setProvided(boolean provided) {
		this.provided = provided;
	}
	
	
}
