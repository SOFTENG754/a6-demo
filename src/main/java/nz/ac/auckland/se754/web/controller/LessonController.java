package nz.ac.auckland.se754.web.controller;

import nz.ac.auckland.se754.web.backend.manager.WordManager;
import nz.ac.auckland.se754.web.backend.model.WordLibrary;
import org.mockito.Mockito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class LessonController {

    @RequestMapping(value="/lesson", method = RequestMethod.GET)
    public String showLessonPage(ModelMap model){
        return "lesson";
    }

    @RequestMapping(value="/lesson/getDefinition", method = RequestMethod.POST)
    @ResponseBody
    public String getDefinition(@RequestParam("word") String word) {
        WordLibrary wordLibrary = Mockito.mock(WordLibrary.class);
        Mockito.when(wordLibrary.getDefinition("valid word")).thenReturn("valid definition");
        WordManager wordManager = new WordManager(wordLibrary);
        String definition = wordManager.retrieveDefinition(word);
        return definition;
    }

    @RequestMapping(value="/lesson/getExample", method = RequestMethod.POST)
    @ResponseBody
    public String getExample(@RequestParam("word") String word) {
        WordLibrary wordLibrary = Mockito.mock(WordLibrary.class);
        Mockito.when(wordLibrary.getExamples("valid word")).thenReturn(new String[]{"valid example", "another valid example"});
        Mockito.when(wordLibrary.getExamples("invalid word")).thenReturn(new String[]{"Unable to find any examples"});
        WordManager wordManager = new WordManager(wordLibrary);
        String[] examples = (String[]) wordManager.retrieveExamples(word);
        return examples[0];
    }

    @RequestMapping(value="/lesson/getSynonymsAndAntonyms", method = RequestMethod.POST)
    @ResponseBody
    public Object getSynonymsAndAntonyms(@RequestParam("word") String word) {
        WordLibrary wordLibrary = Mockito.mock(WordLibrary.class);
        Mockito.when(wordLibrary.getSynonyms("valid word")).thenReturn(new String[]{"synonym1", "synonym2"});
        Mockito.when(wordLibrary.getAntonyms("valid word")).thenReturn(new String[]{"antonym1", "antonym2"});
        Mockito.when(wordLibrary.getSynonyms("invalid word")).thenReturn(null);
        Mockito.when(wordLibrary.getAntonyms("invalid word")).thenReturn(null);
        WordManager wordManager = new WordManager(wordLibrary);
        return wordManager.retrieveSynonymsAndAntonyms(word);
    }
}
