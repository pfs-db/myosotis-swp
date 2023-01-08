package uni.myosotis;

import uni.myosotis.controller.Controller;
import uni.myosotis.logic.IndexcardLogic;
import uni.myosotis.persistence.IndexcardRepository;
import uni.myosotis.objects.Indexcard;

import java.util.List;

public class App {
    public static void main(String[] args) {

        /* Start the application */
        final IndexcardLogic indexcardLogic = new IndexcardLogic();
        final Controller controller = new Controller(indexcardLogic);
        controller.startApplication();


        /* STUFF ZUM TESTEN */
        final IndexcardRepository ir = new IndexcardRepository();
        final List<Indexcard> cards = ir.findAllIndexcards();

        for (Indexcard x : cards) {
            System.out.println("Name:" + x.getName());
        }

    }
}
