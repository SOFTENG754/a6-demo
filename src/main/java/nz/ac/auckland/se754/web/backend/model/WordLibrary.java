package nz.ac.auckland.se754.web.backend.model;

public interface WordLibrary {
    String getDefinition(String word);
    String[] getExamples(String word);
    String[] getSynonyms(String word);
    String[] getAntonyms(String word);
    String getImagePath(String word);
}
