package run;
public class UnitCreator {

	public Hero getHero(String unitType) {

		if (unitType == "Warrior")
			return new Hero("Thor", "God of Thunder", 1000, 1000, 25, 75, 20, 10,10);
		
		else
			return null;

	}

}
