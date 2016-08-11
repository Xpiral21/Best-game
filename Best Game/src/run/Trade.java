package run;

public class Trade {
	public Trade(Hero h, Trader t) {
		System.out.println();
		System.out.println(
				"You have encountered a Trader , you can buy items by typing 1 2 or 3, heal by pressing 'h'or 'e' to exit ");
		System.out.println("Your current gold is : " + h.getGold());
		System.out.println();
		System.out.println(t.gg);
		int itemNumber = 0;
		String userInput = "";
		while (!userInput.equals("e")) {
			while (userInput.equals("h") == false && userInput.equals("e") == false && userInput.equals("1") == false
					&& userInput.equals("2") == false && userInput.equals("3") == false) {

				try {
					synchronized (Main.gigi) {
						Main.gigi.wait();
					}

				} catch (InterruptedException e1) {

				}
				userInput = GUI.getStdin();
			}

			if (userInput.compareTo("e") == 0)
				break;
			if (userInput.contains("h")) {
				if (h.getGold() >= 50) {
					h.setGold(h.getGold() - 50);
					h.setCurrentHitPoints(h.getMaxHitPoints());
					System.out.println("You regain your strength!");
					GUI.getProgressBar().setValue(h.getCurrentHitPoints());
				} else
					System.out.println("Sucks to be you!");
			}
			if (userInput.matches(".*\\d+.*")) {
				itemNumber = Integer.parseInt(userInput);
				if (itemNumber <= t.gg.size()) {
					if (h.getGold() >= t.gg.get(itemNumber - 1).getValue()) {
						t.buyItem(itemNumber - 1, h);
						h.equipItem(h.inventory.getItem(h.inventory.getSize() - 1));
						System.out.println(h);
					System.out.println(t.gg);
						
					} else
						System.out.println("Shooo peasant!");
				}
			}
			userInput = "";
		}
	}
}
