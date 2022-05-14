package edu.wctc;

public enum GemColors implements Gem{
    RED("Red"),ORANGE("Orange"),YELLOW("Yellow"),GREEN("Green"),BLUE("Blue"),PURPLE("Purple"),PINK("Pink"),CYAN("Cyan"),MAGENTA("Magenta"),WHITE("White"),BLACK("Black");
    private final String textValue;
    GemColors (String t) {this.textValue = t;}

    @Override
    public String getGemValue() {
        return textValue + " Gem";
    }
}
