package com.example.demo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioHandler {
    Clip clip;
    public void playMuteSong(boolean mode) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("Happy.wav"));
            if (mode) {
                this.clip = AudioSystem.getClip();
                this.clip.open(audioInputStream);
                this.clip.start();
            } else {
                this.clip.stop();
                this.clip.close();
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
