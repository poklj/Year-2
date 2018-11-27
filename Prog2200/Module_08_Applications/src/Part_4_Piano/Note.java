package Part_4_Piano;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 
 * Musical Notes...as in Do Ra Me... This Note class supports loading the WAV
 * file and preparing to play the note of that WAV file.
 * 
 */
public class Note {

	// The clip to play
	Clip clip;

	// Constructor takes Filename, set up WAV file
	Note(String filename) {

		// Set up Sound for this note.
		try {
			// Open an audio input stream.
			File soundFile = new File(filename);
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Play the Note
	 */
	public void play() {
		if (clip.isRunning())
			clip.stop(); // Stop the player if it is still running
		clip.setFramePosition(0); // rewind to the beginning
		clip.start(); // Start playing
	}

}
