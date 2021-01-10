package net.ads.algorithms.test6;

public enum Urgency {

    LOW(1), AVERAGE(2), HIGH(3);

    private int level;

    Urgency(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
