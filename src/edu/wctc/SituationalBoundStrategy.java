package edu.wctc;

public class SituationalBoundStrategy implements ObtainabilityStrategy{
    private Situation situation;
    private boolean situational;

    public SituationalBoundStrategy(Situation situation) {
        this.situation = situation;
    }

    public void setSituation() {
        if (situation != null) {
            situational = situation.situation();
        }
    }

    @Override
    public boolean obtain(boolean initialObtainability) {
        setSituation();
        return situational;
    }
}
