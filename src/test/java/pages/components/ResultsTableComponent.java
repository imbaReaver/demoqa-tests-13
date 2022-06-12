package pages.components;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsTableComponent {
    public void checkResult (String label, String value) {
        $$(".table-responsive tr").filterBy(text(label)).shouldHave(texts(
                value));
    }
}
