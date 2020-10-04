package net.examples.enums;

public enum Counter {

    INSTANCE;

    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public void process() {
        System.out.println(value);
    }

}
