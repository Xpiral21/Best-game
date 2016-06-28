package run;

public class Trade {
	public Trade(Hero h, Trader t) {
		System.out.println();
		System.out.println("You have encountered a Trader , you can buy items by typing their number.");
		System.out.println("Type a number higher than the highest item number to Exit the shop");
		System.out.println("Your current gold is : " +h.getGold());
		System.out.println();
		System.out.println(t.inventory);
		int itemNumber = 0;
		while (itemNumber >= 0 && itemNumber < t.inventory.getSize()) {
			try {
				synchronized (Main.gigi) {
					Main.gigi.wait();
				}

			} catch (InterruptedException e1) {

			}
			itemNumber = Integer.parseInt(GUI.getStdin());
			if (itemNumber >= 0 && itemNumber < t.inventory.getSize()) {
				if (h.getGold() >= t.inventory.getItem(itemNumber).getValue()) {
					t.buyItem(itemNumber, h);
					h.equipItem(h.inventory.getItem(h.inventory.getSize() - 1));
					System.out.println(h);
				} else
					System.out.println("Shooo peasant!");
			}
		}
	}
}
