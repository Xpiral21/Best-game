package run;

public class Trade {
	public Trade(Hero h, Trader t) {
		System.out.println();
		System.out.println(
				"You have encountered a Trader , you can buy items by typing their number,or heal by pressing 'h'");
		System.out.println("Type a number higher than the highest item number to Exit the shop");
		System.out.println("Your current gold is : " + h.getGold());
		System.out.println();
		System.out.println(t.gg);
		int itemNumber = 0;
		String userInput = "";
		while (!userInput.equals("e")) {
			while (userInput.equals("h") == false && userInput.equals("e") == false && userInput.equals("0") == false
					&& userInput.equals("1") == false && userInput.equals("2") == false) {

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
				} else
					System.out.println("Sucks to be you!");
			} else if (itemNumber >= 0 && itemNumber < t.gg.size()) {
				if (h.getGold() >= t.gg.get(itemNumber).getValue()) {
					t.buyItem(itemNumber, h);
					h.equipItem(h.inventory.getItem(h.inventory.getSize() - 1));
					System.out.println(h);
				} else
					System.out.println("Shooo peasant!");
			}
			userInput = "";
		}
	}
}
