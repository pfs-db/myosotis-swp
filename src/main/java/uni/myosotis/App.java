package uni.myosotis;

import uni.myosotis.controller.Controller;
import uni.myosotis.logic.*;

public class App {
    public static void main(String[] args) {

        /* Start the application */
        final KeywordLogic keywordLogic = new KeywordLogic();
        final IndexcardLogic indexcardLogic = new IndexcardLogic();
        final CategoryLogic categoryLogic = new CategoryLogic();
        final IndexcardBoxLogic indexcardBoxLogic = new IndexcardBoxLogic();
        final LearnsystemLogic learnsystemLogic = new LearnsystemLogic();
        final LinkLogic linkLogic = new LinkLogic();
        final Controller controller = new Controller(indexcardLogic, keywordLogic, categoryLogic, linkLogic, indexcardBoxLogic, learnsystemLogic);
        controller.startApplication();
    }
}


