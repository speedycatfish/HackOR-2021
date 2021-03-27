package rhythm;

import java.util.ArrayList;

public class Rhythm {
	private long measureStartTime, noteStartTime;
	private double notePrecision;
	private ArrayList<Long> measureTimes, noteTimes;

	public Rhythm() {

	}

	public Rhythm(double notePrecision) {
		this.notePrecision = notePrecision;
	}

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

	public void setNotePrecision(double notePrecision) {
		this.notePrecision = notePrecision;
	}
}
