package test;

import javax.sound.midi.MidiChannel;

import jm.gui.sketch.SketchRuler;
import jm.gui.sketch.SketchScore;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class MusicNoteTest {

	public static void main(String[] args) {
		Note n = new Note(2, 2, 2, 2);
		Note n2 = new Note(3,3,3,3);

		Phrase p = new Phrase();
		p.add(n);
		p.add(n2);
		Part part = new Part();
		part.add(p);
		Score newscore = new Score();
		newscore.add(part);

	}

}
