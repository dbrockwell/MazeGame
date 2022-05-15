package edu.wctc;

public interface ObtainabilityStrategy {
    // this is the interface of the strategy that each strategy uses
    boolean obtain(boolean initialObtainability);
}
