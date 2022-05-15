package edu.wctc;

public class Flask {
    private String name = "Flask";
    private int score = 10;
    private static Flask instance = null;
    private boolean obtained = false;

    public String getFlask() {
        if (!obtained) {
            obtained = true;
            return name;
        }
        else {
            return null;
        }
    }

    public int getScore() {
        return score;
    }
    // here is a get instance of a singleton
    public static Flask getInstance() {
        if (instance == null) {
            synchronized (Flask.class) {
                if (instance == null) {
                    instance = new Flask();
                }
            }
        }

        return instance;
    }
}
