package edu.wctc;

public class FreeStrategy implements ObtainabilityStrategy{
    //The strategy where no limitations are placed
    @Override
    public boolean obtain(boolean initialObtainability) {
        return initialObtainability;
    }
}
