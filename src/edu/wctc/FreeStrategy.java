package edu.wctc;

public class FreeStrategy implements ObtainabilityStrategy{
    @Override
    public boolean obtain(boolean initialObtainability) {
        return initialObtainability;
    }
}
