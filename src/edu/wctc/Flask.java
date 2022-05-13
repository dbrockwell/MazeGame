package edu.wctc;

public class Flask {
    private String name = "Flask";
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
