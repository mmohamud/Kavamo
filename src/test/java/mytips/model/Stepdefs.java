package mytips.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import mytips.StubIO;
import mytips.TextualUI;
import mytips.dao.InMemoryBookTipDao;
import mytips.dao.InMemoryWebTipDao;
import static org.junit.Assert.*;

public class Stepdefs {

    private List<String> inputStrings = new ArrayList<>();
    private List<Integer> inputInts = new ArrayList<>();
    private ArrayList<ReadingTip> readingTips = new ArrayList<>();
    private StubIO io;
    private TextualUI ui;
    private ReadingTipManager manager;
    private InMemoryBookTipDao bookTipDao = new InMemoryBookTipDao();
    private InMemoryWebTipDao webTipDao = new InMemoryWebTipDao();

    @Given("^commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja kirja are selected$")
    public void commands_hallinnoi_lukuvinkkejä_lisää_lukuvinkki_ja_kirja_are_selected() throws Throwable {
        inputInts.add(1);
        inputInts.add(1);
        inputInts.add(1);
    }

    @When("^valid isbn \"([^\"]*)\", author \"([^\"]*)\", "
            + "title \"([^\"]*)\", comment \"([^\"]*)\", summary \"([^\"]*)\" are given$")
    public void valid_isbn_author_title_comment_summary_are_given(
            String isbn, String author, String title, String comment, String summary) throws Throwable {
        inputStrings.add("");
        inputStrings.add(isbn);
        inputStrings.add(author);
        inputStrings.add(title);
        inputStrings.add(comment);
        inputStrings.add(summary);
    }

    @When("^commands valmis and lopeta are selected$")
    public void commands_valmis_and_lopeta_are_selected() throws Throwable {
        inputInts.add(4);
        inputStrings.add("");
        inputInts.add(3);

        io = new StubIO(inputStrings, inputInts);

        manager = new ReadingTipManager(bookTipDao, webTipDao);
        ui = new TextualUI(manager, io);
        ui.start();
    }

    @Then("^the booktip is saved and the system prints \"([^\"]*)\"$")
    public void the_booktip_is_saved_and_the_system_prints(String expectedOutput) throws Throwable {
        for (String print : io.getPrints()) {
            System.out.println("print: " + print);
        }
        assertTrue(io.getPrints().contains(expectedOutput));
    }
    
   /*@Given("^commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja Video tai blogipostaus are selected$")
    public void commands_hallinnoi_lukuvinkkejä_lisää_lukuvinkki_ja_Video_tai_blogipostaus_are_selected() throws Throwable {
        inputInts.add(1);
        inputInts.add(1);
        inputInts.add(2);
    }
    
    @When("^valid url \"([^\"]*)\", author \"([^\"]*)\", "
            + "title \"([^\"]*)\", summary \"([^\"]*)\", comment \"([^\"]*)\" are given$")
    public void url(
            String url, String author, String title, String summary, String comment) throws Throwable {
        inputStrings.add("");
        inputStrings.add(url);
        inputStrings.add(author);
        inputStrings.add(title);
        inputStrings.add(comment);
        inputStrings.add(summary);
    }
    
    @Then("^the webtip is saved and the system prints \"([^\"]*)\"$")
    public void the_webtip_is_saved_and_the_system_prints(String expectedOutput) throws Throwable {
        for (String print : io.getPrints()) {
            System.out.println("print: " + print);
        }
        assertTrue(io.getPrints().contains(expectedOutput));
    }*/
}
