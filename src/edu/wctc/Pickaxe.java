package edu.wctc;

public class Pickaxe {
    private String name = "Pickaxe";
    private static Pickaxe instance = null;
    private boolean obtained = false;

    public String getPickaxe() {
        if (!obtained) {
            obtained = true;
            return name;
        }
        else {
            return null;
        }
    }

    public boolean isObtained() {
        return obtained;
    }

    public static Pickaxe getInstance() {
        if (instance == null) {
            synchronized (Flask.class) {
                if (instance == null) {
                    instance = new Pickaxe();
                }
            }
        }

        return instance;
    }
}
