package nz.ac.auckland.se754.web.backend.manager;

import nz.ac.auckland.se754.web.backend.model.WordLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WordManager {
    private final WordLibrary wordLibrary;

    public WordManager(WordLibrary wordLibrary) {
        this.wordLibrary = wordLibrary;
    }

    public String retrieveDefinition(String word) {
        try {
            String definition = wordLibrary.getDefinition(word);
            return Objects.requireNonNullElse(definition, "Unable to find definition");
        } catch (RuntimeException e) {
            return "Connection error";
        }
    }

    public Object retrieveExamples(String word) {
        try {
            String[] examples = wordLibrary.getExamples(word);
            if (examples == null || examples.length == 0) {
                return "Unable to find any examples";
            }
            return examples;
        } catch (RuntimeException e) {
            return "Connection error";
        }
    }

    public Object retrieveSynonymsAndAntonyms(String word) {
        try {
            String[] synonyms = wordLibrary.getSynonyms(word);
            String[] antonyms = wordLibrary.getAntonyms(word);
            ArrayList<String> relatedWords = new ArrayList<>();
            if (synonyms == null && antonyms == null) {
                return "Unable to find any synonyms or antonyms";
            }
            if (synonyms != null) {
                relatedWords.add("Synonyms: ");
                relatedWords.addAll(Arrays.asList(synonyms));
            }
            if (antonyms != null) {
                relatedWords.add("Antonyms: ");
                relatedWords.addAll(Arrays.asList(antonyms));
            }
            return relatedWords;
        } catch (RuntimeException e) {
            return "Connection error";
        }
    }

    public String retrieveImagePath(String word) {
        try {
            String imagePath = wordLibrary.getImagePath(word);
            return Objects.requireNonNullElse(imagePath, "Unable to find image path");
        } catch (RuntimeException e) {
            return "Connection error";
        }
    }
}
