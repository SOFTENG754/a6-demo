package nz.ac.auckland.se754.web.backend.manager;

import nz.ac.auckland.model.WordLibrary;

import java.util.ArrayList;

public class WordManager {
    private WordLibrary wordLibrary;

    public WordManager(WordLibrary wordLibrary) {
        this.wordLibrary = wordLibrary;
    }

    public String retrieveDefinition(String word) {
        try {
            String definition = wordLibrary.getDefinition(word);
            if (definition == null) {
                return "Unable to find definition";
            }
            return definition;
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
                for (String synonym : synonyms) {
                    relatedWords.add(synonym);
                }
            }
            if (antonyms != null) {
                relatedWords.add("Antonyms: ");
                for (String antonym : antonyms) {
                    relatedWords.add(antonym);
                }
            }
            return relatedWords;
        } catch (RuntimeException e) {
            return "Connection error";
        }
    }
}
