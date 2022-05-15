package edu.wctc;

public class Artifact {
    private String name = "Artifact";
    private int score = 50;
    private static Artifact instance = null;
    private boolean obtained = false;

    public String getArtifact() {
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

    //Only one artifact can be in the maze so there is a singleton
    public static Artifact getInstance() {
        if (instance == null) {
            synchronized (Artifact.class) {
                if (instance == null) {
                    instance = new Artifact();
                }
            }
        }

        return instance;
    }
}
