package net.examples.enums;

public class ValidatorContext {

    private ValidatorStrategy strategy;

    public ValidatorContext(ValidatorStrategy strategy) {
        this.strategy = strategy;
    }

    public void setValidator(ValidatorStrategy validator) {
        this.strategy = validator;
    }

    public void runValidation(String content) {
        strategy.doValidation(content);
    }

}