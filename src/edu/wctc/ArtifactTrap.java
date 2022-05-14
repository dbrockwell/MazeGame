package edu.wctc;

public class ArtifactTrap implements Situation {
    private boolean isOpen = true;
    private static ArtifactTrap instance = null;

    public boolean isOpen() {
        return isOpen;
    }

    public void pressButton (){
        if (isOpen) {
            isOpen = false;
        }
    }

    public static ArtifactTrap getInstance() {
        if (instance == null) {
            synchronized (ArtifactTrap.class) {
                if (instance == null) {
                    instance = new ArtifactTrap();
                }
            }
        }

        return instance;
    }

    @Override
    public boolean situation() {
        return isOpen;
    }
}
