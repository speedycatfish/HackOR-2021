package rhythm;

import java.util.ArrayList;

public class Rhythm {
	private long measureStartTime, noteStartTime;// time stamps for when the audio file is played for recording both times
	private double notePrecision, minimumNotePrecision;// minimum note precision is for when multiple notes round to the same time
	private ArrayList<Long> measureTimes, noteTimes;
	private int time1 = 4, time2 = 4;// top and bottom for time signature respectively. defaults to 4/4

	private ArrayList<Note> notes;

	private static final Note BAR = new Note(-1);

	public Rhythm() {

	}

	public Rhythm(double notePrecision) {
		this.notePrecision = notePrecision;
		this.minimumNotePrecision = notePrecision;
	}

	public void startMeasures() {
		measureStartTime = System.currentTimeMillis();
		measureTimes = new ArrayList<>();
	}

	public void startNotes() {
		noteStartTime = System.currentTimeMillis();
		noteTimes = new ArrayList<>();
	}

	public void addMeasure() {
		measureTimes.add(System.currentTimeMillis() - measureStartTime);
	}

	public void addNote() {
		noteTimes.add(System.currentTimeMillis() - noteStartTime);
	}

	public void setNotePrecision(double notePrecision) {
		this.notePrecision = notePrecision;
	}

	public void setMinimumNotePrecision(double notePrecision) {
		this.minimumNotePrecision = notePrecision;
	}

	public void roundNotes() {
		int measureIndex = 0;
		notes.add(BAR);
		for (long noteTime : noteTimes) {
			if (noteTime <= measureTimes.get(0)) {
				notes.add(new Note(0));
			}
			while (measureIndex < measureTimes.size() && noteTime > measureTimes.get(measureIndex)) {
				measureIndex++;
				notes.add(BAR);
			}
			if (measureIndex == measureTimes.size()) {
				System.out.println("note detected after end of all measures.");
				break;
			}

			long bar1 = measureTimes.get(measureIndex);
			long bar2 = measureTimes.get(measureIndex + 1);
			double timeChunk = notePrecision * (double) (bar2 - bar1);
			notes = new ArrayList<>();
			for (int i = 0;; i++) {
				double time = i * timeChunk + bar1;
				if (time > noteTime) {
					double lastTime = time - timeChunk;
					Note newNote = new Note();
					if (Math.abs(noteTime - lastTime) > Math.abs(noteTime - time)) {
						newNote.regNotes = i;
					} else {
						newNote.regNotes = i - 1;
					}
					notes.add(newNote);
					break;
				}
			}
		}
		notes.add(BAR);
	}

	static class Note {
		int regNotes = 0;
		int minNotes = 0;

		public Note(int regNotes) {
			this.regNotes = regNotes;
		}

		public Note() {
		}

	}
}
