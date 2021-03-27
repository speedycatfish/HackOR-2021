package rhythm;

import java.util.ArrayList;

public class Rhythm {
	private long measureStartTime, noteStartTime;
	private ArrayList<Long> measureTimes, noteTimes;

	public void startMeasures() {
		measureStartTime = System.currentTimeMillis();
	}

	public void startNotes() {
		noteStartTime = System.currentTimeMillis();
	}

	public void addMeasure() {
		measureTimes.add(System.currentTimeMillis());
	}

	public void addNote() {
		noteTimes.add(System.currentTimeMillis());
	}
}
