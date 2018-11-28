package mytips.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import mytips.StubIO;
import mytips.TextualUI;
import static org.junit.Assert.*;

public class Stepdefs {

    private List<String> inputStrings = new ArrayList<>();
    private List<Integer> inputInts = new ArrayList<>();
    private ArrayList<ReadingTip> readingTips = new ArrayList<>();
    private StubIO io;
    private TextualUI ui;
    private StubManager manager;

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

    @When("^command valmis is selected$")
    public void command_valmis_is_selected() throws Throwable {
        inputInts.add(4);
        inputStrings.add("");
        inputInts.add(3);
        
        io = new StubIO(inputStrings, inputInts);
        manager = new StubManager(readingTips, io);
        ui = new TextualUI(manager, io);
        ui.start();
    }

    @Then("^the booktip is saved and the system prints \"([^\"]*)\"$")
    public void the_booktip_is_saved_and_the_system_prints(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
}
