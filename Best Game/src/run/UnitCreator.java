package run;
public class UnitCreator {

	public Unit getUnit(String unitType) {

		if (unitType == "Warrior")
			return new Hero("Thor", "God of Thunder", 1000, 1000, 25, 75, 20, 10);
		else if (unitType == "Monster")
			return new Monster("Loki", "Lord of Jotunheim", 800, 800, 50, 75, 20, 10);
		else
			return null;

	}

}
