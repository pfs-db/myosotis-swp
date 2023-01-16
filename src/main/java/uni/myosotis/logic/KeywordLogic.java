package uni.myosotis.logic;

import uni.myosotis.objects.Keyword;
import uni.myosotis.persistence.KeywordRepository;

import java.util.List;
import java.util.Optional;


public class KeywordLogic {
    /**
     * The repository for the Indexcards.
     */
    final KeywordRepository KeywordRepository;

    /**
     * Creates a new IndexcardLogic.
     */
    public KeywordLogic () {
        this.KeywordRepository = new KeywordRepository();
    }

    /**
     * Creates a new Keyword and saves it in the database.
     * If already a Keyword with the same word exists, it will throw a IllegalStateException.
     *
     * @param word The word of the Keyword.
     * @param indexcard_name The name of the Indexcard.
     */
    public void createKeyword(String word, String indexcard_name) {
        if (KeywordRepository.findKeyword(word).isPresent()) {
            editKeyword(word,indexcard_name); // FIXME problem here, just the last indexcard keeps the indexcard_name
        } else {
            Keyword keyword = new Keyword(word,indexcard_name);
            KeywordRepository.saveKeyword(keyword);
        }
    }

    /**
     * Edits an existing Keyword and saves it in the database.
     * If there is no Keyword with the given word, it will throw a IllegalStateException.
     *
     * @param word The word of the Keyword.
     */
    public void editKeyword(String word, String name) {
        if (KeywordRepository.findKeyword(word).isPresent()) {
            Keyword Keyword = new Keyword(word, name);
            int checkvalue = KeywordRepository.updateKeyword(Keyword);
            if (checkvalue != 0) {
                throw new IllegalStateException("Es existiert kein Schlagwort mit diesem Namen.");
            }
        }
    }
    /**
     * Deletes an existing Keyword and saves it in the database.
     * If there is no Keyword with the given word, it will throw a IllegalStateException.
     *
     * @param word The word of the Keyword.
     */
    public void deleteKeyword(String word) {
        if (KeywordRepository.findKeyword(word).isPresent()) {
            int checkvalue = KeywordRepository.deleteKeyword(word);
            if (checkvalue != 0) {
                throw new IllegalStateException("Es existiert keine Karteikarte mit diesem Namen.");
            }
        }
    }

    /**
     * Returns all Indexcards.
     *
     * @return All Indexcards.
     */
    public List<Keyword> getAllKeywords() {
        return KeywordRepository.findAllKeywords();
    }

    /**
     * Return the Keyword with the given word.
     *
     * @param keyword The word of the Keyword.
     * @return The Keyword if it exists.
     */
    public Optional<Keyword> getKeyword (String keyword) {
        return KeywordRepository.findKeyword(keyword);
    }

    /**
     * Returns KeywordRepository.
     *
     * @return KeywordRepository
     */
    public KeywordRepository getKeywordRepository() {
        return KeywordRepository;
    }
}