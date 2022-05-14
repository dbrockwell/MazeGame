package edu.wctc;

public class GemFactory implements FactoryCreate {

    @Override
    public String getGem(int index) {
        return GemColors.values()[index].getGemValue();
    }
}
