package edu.wctc;

public class GemFactory implements FactoryCreate {
    // A part of the factory that gets the string for gem
    @Override
    public String getGem(int index) {
        return GemColors.values()[index].getGemValue();
    }
}
