package nz.ac.auckland.se754.web.service;

import nz.ac.auckland.se754.web.backend.exception.NoUserFoundException;
import nz.ac.auckland.se754.web.backend.exception.PrivateProgressException;
import nz.ac.auckland.se754.web.model.LearningProgress;
import nz.ac.auckland.se754.web.model.User;

import java.util.HashMap;
import java.util.Map;

public class LearningProgressManager {
    private static Map<String, LearningProgress> userProgressMap = new HashMap<>();

    public static void initialize(User newUser, User returnUser){

        returnUser.getLearningProgress().setPrivate(true);
        returnUser.getLearningProgress().updateNumberOfCompletedCourse();
        returnUser.getLearningProgress().updateNumberOfCompletedCourse();
        returnUser.getLearningProgress().updateNumberOfCompletedCourse();
        returnUser.getLearningProgress().updateNumberOfCompletedCourse();
    }

    public static LearningProgress getLearningProgress(String username) throws NoUserFoundException, PrivateProgressException {
        if(userProgressMap.containsKey(username)){
            LearningProgress learningProgress = userProgressMap.get(username);
            System.out.println(learningProgress.getIsPrivate());
            if(learningProgress.getIsPrivate()){
                throw new PrivateProgressException();
            }
            return learningProgress;
        }else{
            throw new NoUserFoundException();
        }
    }

    public static void startLearningProgress(String username, LearningProgress learningProgress){
        userProgressMap.put(username, learningProgress);
    }
}
