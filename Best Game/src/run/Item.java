package run;

public class Item {
    private String name;

    private int hp = 0;
    private int armor = 0;
    private int evasion = 0;
    private int accuracy = 0;
    private int maxDamage = 0;
    private int minDamage = 0;
    int rand = (int) (Math.random() * 20) + 1;
    double rand2 = Math.random();
    double rand3 = Math.random() * 6;
    int caseNumber = (int) (Math.random() * 3 + 1);

    public Item() {


        if (rand2 < 0.5) {
            armor = rand * 2;
            switch (caseNumber) {
                case 1:
                    hp = rand * 2;
                    break;
                case 2:
                    evasion = rand * 2;
                    break;
                case 3:
                    accuracy = rand * 2;
                    break;

            }
        }


        if (rand2 >= 0.5) {
            switch (caseNumber) {
                case 1:
                    hp = rand * 2;
                    break;
                case 2:
                    armor = rand * 2;
                    break;
                case 3:
                    evasion = rand * 2;
                    break;
                case 4:
                    accuracy = rand * 2;
            }
            minDamage = rand * 1;
            maxDamage = rand * 2;

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
                name = name.concat(" Helm");
            } else if (rand3 < 2) {
                name = name.concat(" Chest");
            } else if (rand3 < 3) {
                name = name.concat(" Gloves");
            } else if (rand3 < 4) {
                name = name.concat(" Pants");
            } else if (rand3 < 6) {
                name = name.concat(" Boots");
            }
        } else {
            if (rand3 < 2) {
                name = name.concat(" Sword");
            } else if (rand3 < 4) {
                name = name.concat(" Spear");
            } else if (rand3 < 6) {
                name = name.concat(" Staff");
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

    public int getAccuracy() {
        return accuracy;
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
        if (accuracy > 0) {
            str = str + "ACCURACY : " + accuracy + System.lineSeparator();
        }

        return str;
    }
}
