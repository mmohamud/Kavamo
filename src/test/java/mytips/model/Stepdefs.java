package mytips.model;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.ArrayList;
import java.util.List;
import mytips.StubIO;
import mytips.TextualUI;
import static org.junit.Assert.*;
import mytips.dao.InMemoryReadingTipDao;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mytips.dao.ReadingTipDao;
import mytips.database.Database;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;
import java.sql.Connection;

public class Stepdefs {

    private List<String> inputStrings = new ArrayList<>();
    private List<Integer> inputInts = new ArrayList<>();
    private ArrayList<ReadingTip> readingTips = new ArrayList<>();
    private StubIO io;
    private TextualUI ui;
    private ReadingTipManager manager;
    private ReadingTipDao readingTipDao;
    private Database db;

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
        inputStrings.add(isbn);
        inputStrings.add(author);
        inputStrings.add(title);
        inputStrings.add(comment);
        inputStrings.add(summary);
    }

    @When("^command lopeta is selected$")
    public void command_lopeta_is_selected() throws Throwable {
        inputInts.add(3);

        this.prepareDB();

        io = new StubIO(inputStrings, inputInts);

        manager = new ReadingTipManager(readingTipDao);
        ui = new TextualUI(manager, io);
        ui.start();
    }

    @Then("^the booktip is saved and the system prints \"([^\"]*)\"$")
    public void the_booktip_is_saved_and_the_system_prints(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("^commands hallinnoi lukuvinkkejä, lisää lukuvinkki ja Video tai blogipostaus are selected$")
    public void commands_hallinnoi_lukuvinkkejä_lisää_lukuvinkki_ja_Video_tai_blogipostaus_are_selected() throws Throwable {
        inputInts.add(1);
        inputInts.add(1);
        inputInts.add(2);
    }

    @When("^valid url \"([^\"]*)\", author \"([^\"]*)\", "
            + "title \"([^\"]*)\", summary \"([^\"]*)\", comment \"([^\"]*)\" are given$")
    public void url(
            String url, String author, String title, String summary, String comment) throws Throwable {
        inputStrings.add(url);
        inputStrings.add(author);
        inputStrings.add(title);
        inputStrings.add(comment);
        inputStrings.add(summary);
    }

    @When("^valid url \"([^\"]*)\", author \"([^\"]*)\", title \"([^\"]*)\", "
            + "summary \"([^\"]*)\", comment \"([^\"]*)\"  "
            + "and type \"([^\"]*)\" are given$")
    public void valid_url_author_title_summary_comment_and_type_are_given(
            String url, String author, String title, String summary, String comment,
            String type) throws Throwable {
        inputStrings.add(url);
        inputStrings.add(author);
        inputStrings.add(title);
        inputStrings.add(comment);
        inputStrings.add(summary);
        inputStrings.add(type);
    }

    @Then("^the webtip is saved and the system prints \"([^\"]*)\"$")
    public void the_webtip_is_saved_and_the_system_prints(String expectedOutput) throws Throwable {
        assertTrue(io.getPrints().contains(expectedOutput));
    }

    @Given("^commands selaa lukuvinkkejä and listaa kaikki lukuvinkit are selected$")
    public void commands_selaa_lukuvinkkejä_and_listaa_kaikki_lukuvinkit_are_selected() throws Throwable {
        inputInts.add(2);
        inputInts.add(1);
        inputInts.add(4);
        inputInts.add(3);

        this.prepareDB();

        io = new StubIO(inputStrings, inputInts);

        manager = new ReadingTipManager(readingTipDao);
        ui = new TextualUI(manager, io);
        ui.start();
    }

    @Then("^the system prints \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_system_prints_and_and_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        for (String p : io.getPrints()) {
            System.out.println("p: " + p);
        }
        assertTrue(io.getPrints().contains(arg1));
        assertTrue(io.getPrints().contains(arg2));
        assertTrue(io.getPrints().contains(arg3));
        assertTrue(io.getPrints().contains(arg4));
    }

    @Given("^commands selaa lukuvinkkejä and näytä yhden lukuvinkin tarkat tiedot are selected$")
    public void commands_selaa_lukuvinkkejä_and_näytä_yhden_lukuvinkin_tarkat_tiedot_are_selected() throws Throwable {
        inputInts.add(2);
        inputInts.add(2);
    }

    @When("^valid id \"([^\"]*)\" is given and command palaa alkuun is selected$")
    public void valid_id_is_given_and_command_palaa_alkuun_is_selected(String id) throws Throwable {
        inputInts.add(Integer.parseInt(id));
        inputInts.add(4);
    }

    @Then("^all the details from the readingtip are printed$")
    public void all_the_details_from_the_readingtip_are_printed() throws Throwable {
        assertTrue(io.getPrints().contains("Kirjoittaja:  Robert Martin "));
        assertTrue(io.getPrints().contains("Otsikko:  Clean Code: A Handbook of Agile Software Craftsmanship "));
        assertTrue(io.getPrints().contains("Tyyppi:  kirja "));
        assertTrue(io.getPrints().contains("ISBN:  978-0-13-235088-4 "));
        assertTrue(io.getPrints().contains("Tiivistelmä:  Even bad code can function. But if code  "));
        assertTrue(io.getPrints().contains(" isn't clean, it can bring a development  "));
        assertTrue(io.getPrints().contains(" organization to its knees. "));
        assertTrue(io.getPrints().contains("Kommentti:  kiinnostava kirja hyvästä koodista "));
        assertTrue(io.getPrints().contains("Status:  Ei luettu "));
    }

    //Helper methods
    private void prepareDB() {
        try {        
            db = new Database("jdbc:sqlite:?cache=shared");
            Connection c = db.getConnection();
            Statement statement = c.createStatement();
            String dropReadingTip = "DROP TABLE ReadingTip";
            statement.execute(dropReadingTip);
            
            
            String sql = "CREATE TABLE IF NOT EXISTS ReadingTip ("
                    + "id integer PRIMARY KEY,"
                    + "author varchar(40),"
                    + "title varchar(40),"
                    + "summary varchar(200),"
                    + "comment varchar(100),"
                    + "isbn varchar(20),"
                    + "url varchar(100),"
                    + "type varchar(20),"
                    + "readStatus boolean"
                    + ");";
            
            statement.execute(sql);
            String sql2 = "DELETE FROM ReadingTip";
            statement.execute(sql2);
            statement.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadingTipTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        } catch (SQLException e) {
            System.out.println("Tietokannan alustus epäonnistui");
            System.out.println(e.getMessage());
        }
        this.readingTipDao = new ReadingTipDao(db);

        try {
            this.addReadingTipsToDB();
        } catch (SQLException ex) {
            System.out.println("Lukuvinkkien lisäys testitietokantaan ei "
                    + "onnistunut");
            System.out.println("ex: " + ex.getMessage());
        }
    }

    private void addReadingTipsToDB() throws SQLException {
        ReadingTip bookTip1 = new ReadingTip("Robert Martin",
                "Clean Code: A Handbook of Agile Software Craftsmanship",
                "Even bad code can function. But if code isn't clean, "
                + "it can bring a development organization to its knees.",
                "kiinnostava kirja hyvästä koodista", "kirja", false);
        bookTip1.setIsbn("978-0-13-235088-4");

        ReadingTip bookTip2 = new ReadingTip("Margaret Atwood", "Orjattaresi",
                "Margaret Atwoodin Orjattaresi on vavahduttava dystopia "
                + "lähitulevaisuuden Yhdysvalloista, jossa "
                + "vanhatestamentilliset "
                + "fundamentalistit ovat ottaneet vallan.Yli 30 vuotta "
                + "ensijulkaisunsa jälkeen romaanin teemat vapaudesta ja "
                + "naisten oikeuksista ovat nyt ajankohtaisempia kuin koskaan.",
                "", "kirja", false);

        ReadingTip webTip1 = new ReadingTip("Nicola Apicella",
                "Consistency models", "", "", "blogpost", false);

        ReadingTip webTip2 = new ReadingTip("", "Merge sort algorithm", "",
                "Hyvä selitys merge sortin toiminnasta esimerkin avulla",
                "video", false);

        readingTipDao.saveOrUpdate(bookTip1);
        readingTipDao.saveOrUpdate(bookTip2);
        readingTipDao.saveOrUpdate(webTip1);
        readingTipDao.saveOrUpdate(webTip2);
    }

}
