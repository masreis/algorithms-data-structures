package net.ads.algorithms.test6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TranscriptHelper {

    /**
     * 
     * 
     * 
     * Transcripts
     * 
     * Some clients may want a written copy of the interactions they have with the
     * experts in our network. In such cases, we record the conversation and later
     * we send them to be transcribed in separated services. Given the following
     * structure for a transcript request { "language": "en/es/pt", "urgency":
     * "low/average/high" } And the following providers and characteristics:
     * Provider A (for automatic) quality: low speed: high limitations: English only
     * 
     * Provider M (for manual) quality: medium speed: medium
     * 
     * Write an algorithm that takes one transcript request as input and outputs the
     * provider that maximizes quality while respecting the constraints.
     * 
     * Examples Input: {"language": "en", "urgency": "high"} output: "Provider A"
     * 
     * ---
     * 
     * Input: {"language": "pt", "urgency": "low"} output: "Provider M"
     * 
     * 
     * 
     */

    List<TranscriptProvider> availableProviders = new ArrayList<TranscriptProvider>();

    public TranscriptHelper() {
        TranscriptProvider providerA = new TranscriptProvider();
        providerA.setLanguage("en");
        providerA.setQuality(Urgency.LOW);
        providerA.setSpeed(Urgency.HIGH);

        TranscriptProvider providerM = new TranscriptProvider();
        providerM.setQuality(Urgency.AVERAGE);
        providerM.setSpeed(Urgency.AVERAGE);

        availableProviders.add(providerA);
        availableProviders.add(providerM);

    }

    public TranscriptProvider getBestProvider(Request request) {

        List<TranscriptProvider> result = new ArrayList<>();

        if (request.getLanguage() != null) {
            result.addAll(availableProviders.stream().filter(lang -> request.getLanguage().equals(lang.getLanguage()))
                    .collect(Collectors.toList()));
        }

        switch (request.getUrgency()) {
        case AVERAGE:

            result.stream()
                    .filter(prov -> request.getUrgency() == Urgency.LOW && request.getUrgency() == Urgency.AVERAGE);

            break;

        default:
            break;
        }

        return null;
    }
}
