package net.ads.algorithms.test6;

public class Executor {

    public static void main(String[] args) {

        TranscriptHelper helper = new TranscriptHelper();

        // Example 1
        Request parameter1 = new Request();
        parameter1.setLanguage("en");
//        parameter1.setUrgency("HIGH");
        System.out.println(helper.getBestProvider(parameter1));

        // Example 2
        TranscriptProvider parameter2 = new TranscriptProvider();
        parameter2.setLanguage("pt");
//        parameter2.setUrgency(Urgency.LOW);
//        System.out.println(helper.getBestProvider(parameter2));

    }

}
