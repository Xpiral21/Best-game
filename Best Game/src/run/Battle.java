package run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {
	public Battle(Hero player, Monster monster) throws IOException {
		System.out.println("You encounter " + monster.getDescription() + "\n");
		System.out.println("Battle starts (" + player.getStatus() + " / " + monster.getStatus() + ")");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (player.isAlive() && monster.isAlive()) {
			System.out.print("Attack (a),use skill (s), heal (h) or run away (r)? ");
			String action = in.readLine();
			if (action.equals("h")) {
				player.heal();
				player.defend(monster, "a");
			} else if (action.equals("s")) {
				monster.defend(player, "s");
				player.defend(monster, "a");
			} else if (action.equals("a")) {
				monster.defend(player, "a");
				player.defend(monster, "a");
			}else if (action.equals("r")){
				player.defend(monster, "a");
				player.charLocation[]=player.prevLocation[];
			}
		}
	}
}
