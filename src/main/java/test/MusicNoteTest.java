package test;

import jm.gui.show.ShowScore;
import jm.music.data.Note;
import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class MusicNoteTest {

	public static void main(String[] args) {
// Have a  scale
		Phrase p = new Phrase();
		
		for (int i = 0; i < 20; i++) {
			p.add(new Note(60+i,0.1,i*5+20));
		}
		Part part = new Part();
		part.add(p);
		Score newscore = new Score();
		newscore.add(part);
		Play.midi(part);
		new ShowScore(newscore);

	}

}
