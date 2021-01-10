package net.ads.algorithms.test6;

public class TranscriptProvider {

    private String language;
    private Urgency quality;
    private Urgency speed;

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setQuality(Urgency quality) {
        this.quality = quality;
    }

    public Urgency getQuality() {
        return quality;
    }

    public void setSpeed(Urgency speed) {
        this.speed = speed;
    }

    public Urgency getSpeed() {
        return speed;
    }
}
