package run;

public class Trade {
	public Trade(Hero h, Trader t) {
		System.out.println(t.inventory);
		System.out.println("Buy an item by typing it's number");
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
