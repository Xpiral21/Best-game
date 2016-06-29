package run;

public class Item {
    private String name;

    private int hp = 0;
    private int armor = 0;
    private int evasion = 0;
    private int accuracy = 0;
    private int maxDamage = 0;
    private int minDamage = 0;
    private int rand = (int) (Math.random() * 20) + 1;
    private double rand2 = Math.random();
    private double rand3 = Math.random() * 6;
    private int caseNumber = (int) (Math.random() * 3 + 1);
    
    private String itemType;
    int lvlC=MainThread.getHero().getLevel();
    private int value = ((int) ((Math.random()*20)+10))+(45*lvlC);
    public Item() {


        if (rand2 < 0.5) {
            armor = rand * 2+(13*lvlC);
            switch (caseNumber) {
                case 1:
                    hp = rand * 2+(50*lvlC);
                    break;
                case 2:
                    evasion = rand * 2+(6*lvlC);
                    break;
                case 3:
                    accuracy = rand * 2+(7*lvlC);
                    break;

            }
        }


        if (rand2 >= 0.5) {
            switch (caseNumber) {
                case 1:
                    hp = rand * 2+(64*lvlC);
                    break;
                case 2:
                    armor = rand * 2+(15*lvlC);
                    break;
                case 3:
                    evasion = rand * 2+(6*lvlC);
                    break;
                case 4:
                    accuracy = rand * 2+(7*lvlC);
            }
            minDamage = rand * 1+(10*lvlC);
            maxDamage = rand * 2+(20*lvlC);

        }
        name = randName();

    }

    private String randName() {
        String name = "";
        if (rand < 8) {
            name = name.concat("Lesser");
        } else if (rand < 14) {
            name = name.concat("Medium");
        } else {
            name = name.concat("Greater");
        }

        if (rand2 < 0.5) {
            if (rand3 < 1) {
                name = name.concat(" Helmet");
                itemType="Helmet";
            } else if (rand3 < 2) {
                name = name.concat(" Chest");
                itemType="Chest";
            } else if (rand3 < 3) {
                name = name.concat(" Gloves");
                itemType="Gloves";
            } else if (rand3 < 4) {
                name = name.concat(" Pants");
                itemType="Pants";
            } else if (rand3 < 6) {
                name = name.concat(" Boots");
                itemType="Boots";
            }
        } else {
            if (rand3 < 2) {
                name = name.concat(" Sword");
                itemType="Sword";
            } else if (rand3 < 4) {
                name = name.concat(" Spear");
                itemType="Spear";
            } else if (rand3 < 6) {
                name = name.concat(" Staff");
                itemType="Staff";
            }
        }
        if (hp > 0) {
            name = name.concat(" of Health");

        } else if (evasion > 0) {
            name = name.concat(" of Evasion");
        } else if (accuracy > 0) {
            name = name.concat(" of Accuracy");
        }
        return name;
    }


    public String getItemType() {
		return itemType;
	}

	public String getName() {
        return name;
    }

    public int getMaxHitPoints() {
        return hp;
    }

    public int getArmor() {
        return armor;
    }

    public int getEvasion() {
        return evasion;
    }
    public int getValue(){
    	return value;
    }
    public int getAccuracy() {
        return accuracy;
    }
    public int getMaxDamage() {
        return maxDamage;
    }
    public int getMinDamage() {
        return minDamage;
    }
    public String toString() {
        String str = name + System.lineSeparator();
        if (hp > 0) {
            str = str + "LIFE : " + hp + System.lineSeparator();
        }
        if (armor > 0) {
            str = str + "ARMOR : " + armor + System.lineSeparator();
        }
        if (evasion > 0) {
            str = str + "EVASION : " + evasion + System.lineSeparator();
        }
        if (accuracy > 0) {
            str = str + "ACCURACY : " + accuracy + System.lineSeparator();
        }
        if (minDamage > 0) {
            str = str + "MAXIMUM DAMAGE : " + maxDamage + System.lineSeparator();
        }
        if (maxDamage > 0) {
            str = str + "MIN DAMAGE : " + minDamage + System.lineSeparator();
        }
        	str= str + "Gold Value : " + value +System.lineSeparator();

        return str;
    }
}
