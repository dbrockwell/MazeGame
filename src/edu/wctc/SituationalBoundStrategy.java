package edu.wctc;

public class SituationalBoundStrategy implements ObtainabilityStrategy{
    boolean restriction;

    public SituationalBoundStrategy(boolean restriction) {
        this.restriction = restriction;
    }

    @Override
    public boolean obtain(boolean initialObtainability) {
        if (restriction) {
            return true;
        }
        else {
            return false;
        }
    }
}
