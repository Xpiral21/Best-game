package run;

import java.awt.EventQueue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.io.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
import javazoom.jl.decoder.JavaLayerException;

public class Main {
	static MonitorObject gigi = new MonitorObject();
	static Thread t;
	private static SoundJLayer soundToPlay;
	
	
	
	public static SoundJLayer getSoundToPlay() {
		return soundToPlay;
	}



	public static void main(String[] args) {
		
        soundToPlay = new SoundJLayer("lib/MelodiaEpica.mp3");
        soundToPlay.play();
		t = new MainThread();
		
		try {
			EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					try {
						GUI window = new GUI();
						window.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.start();
		
	
		
	}
}

/*
 * if (m.getRoom(hero.charLocation[0], hero.charLocation[1]) instanceof
 * MonsterRoom) { MonsterRoom temp = (MonsterRoom)
 * (m.getRoom(hero.charLocation[0], hero.charLocation[1])); try { Battle
 * oneBattle = new Battle(hero, temp.getMonster()); } catch (IOException ex) {
 * Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); } } } //
 * try {
 */ // // Save gigi=new Save(hero);
	// // Load l = new Load(hero);
	// //while(hero.isAlive()){
	//
	// //}
	// } catch (IOException ex) {
	// Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
	// }
