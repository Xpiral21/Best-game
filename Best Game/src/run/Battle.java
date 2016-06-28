package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {

	public Battle(Hero player, Monster monster) throws IOException {
		System.out.println("\n"+"You encounter " + monster.getDescription() + "\n");
		System.out.println("Battle starts (" + player.getStatus() + " VS " + monster.getStatus() + ")");
		
		System.out.print("Attack (a),use skill (s), heal (h) or run away (r)? ");
		while (player.isAlive() && monster.isAlive()) {
			System.out.println();
			try {
				synchronized (Main.gigi) {
					Main.gigi.wait();
				}

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block

			}
			String action = GUI.getStdin();
			if (action.equals("h")) {
				player.heal();
				player.defend(monster, "a");
			} else if (action.equals("s")) {
				monster.defend(player, "s");
				player.defend(monster, "a");
			} else if (action.equals("a")) {
				monster.defend(player, "a");
				player.defend(monster, "a");
			} else if (action.equals("r")) {
				player.defend(monster, "a");
				player.charLocation[0] = player.prevLocation[0];
				player.charLocation[1] = player.prevLocation[1];
				break;
			}
		}
		if (!monster.isAlive()) {
			System.out.println("You stole from a dead body ...");
			player.setGold(player.getGold() + (int) (Math.random() * 10) + 10);
			player.setCurrentExperiencePoints((int) (player.getCurrentExperiencePoints()+Math.random()*250));
			System.out.println("Current XP : "+player.getCurrentExperiencePoints()+"/"+player.getCurrentExperienceRequiered());
			player.levelUP();
		}

	}
}
