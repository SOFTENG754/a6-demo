package nz.ac.auckland.se754.web.backend.manager;

import nz.ac.auckland.se754.web.backend.exception.NoUserFoundException;
import nz.ac.auckland.se754.web.backend.exception.PrivateProgressException;
import nz.ac.auckland.se754.web.backend.model.LearningProgress;

import java.util.HashMap;
import java.util.Map;

public class LearningProgressManager {
    private static Map<String, LearningProgress> userProgressMap = new HashMap<>();

    public static LearningProgress getLearningProgress(String username) throws NoUserFoundException, PrivateProgressException {
        if(userProgressMap.containsKey(username)){
            LearningProgress learningProgress = userProgressMap.get(username);
            if(learningProgress.getIsPrivate()){
                throw new PrivateProgressException();
            }
            return learningProgress;
        }else{
            throw new NoUserFoundException();
        }
    }

    public static void startLearningProgress(String username){
        userProgressMap.put(username, new LearningProgress());
    }
}
