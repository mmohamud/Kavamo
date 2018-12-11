package mytips;

import java.sql.SQLException;
import java.util.*;
// import java.util.logging.Level; // checkstyle herjaa: unused
// import java.util.logging.Logger; // checkstyle herjaa: unused
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mytips.model.ReadingTip;
import mytips.model.ReadingTipManager;
import mytips.model.*;

public class TextualUI {

    private ReadingTipManager tipManager;
    private IO io;

    public TextualUI(ReadingTipManager tipManager, IO io) {
        this.tipManager = tipManager;
        this.io = io;
        io.print("\nTervetuloa lukuvinkkisovellukseen!");
    }

    public void start() {
        io.print("\nMitä haluat tehdä?\n"
                + "1 - Hallinnoi lukuvinkkejä\n"
                + "2 - Selaa lukuvinkkejä\n"
                + "3 - Lopeta\n");

        int action = io.nextInt();

        switch (action) {
            case 1:
                this.manageReadingTips();
                break;
            case 2:
                this.searchReadingTips();
                break;
            case 3:
                break;
            default:
                this.start();
                break;
        }
    }

    private void manageReadingTips() {
        io.print("\nLukuvinkkien hallinnointi\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Lisää lukuvinkki\n"
                + "2 - Muokkaa lukuvinkkiä\n"
                + "3 - Poista lukuvinkki\n"
                + "4 - Palaa alkuun\n");

        int action = io.nextInt();

        switch (action) {
            case 1:
                this.addReadingTip();
                break;
            case 2:
                this.modifyReadingTip();
                break;
            case 3:
                this.removeReadingTip();
                break;
            case 4:
                this.start();
                break;
            default:
                this.manageReadingTips();
                break;
        }
    }

    private void searchReadingTips() {
        io.print("\nLukuvinkkien selaus\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Listaa kaikki lukuvinkit\n"
                + "2 - Näytä yhden lukuvinkin tarkat tiedot\n"
                + "3 - Näytä hakuehdolla\n"
                + "4 - Palaa alkuun\n");

        int action = io.nextInt();

        switch (action) {
            case 1:
                this.printReadingTips();
                break;
            case 2:
                this.showReadingTip();
                break;
            case 3:
                this.conditionalSearch();
            //break;
            case 4:
                this.start();
                break;
            default:
                this.searchReadingTips();
                break;
        }
    }

    private void addReadingTip() {
        io.print("\nLukuvinkin lisäys\n\n"
                + "Minkä lukuvinkin haluat lisätä?\n"
                + "1 - Kirja\n"
                + "2 - Video tai blogipostaus\n"
                + "3 - Podcast\n"
                + "4 - Palaa lukuvinkkien hallinnointivalikkoon\n");

        int action = io.nextInt();

        switch (action) {
            case 1:
                this.addBook();
                break;
            case 2:
                this.addWeb();
                break;
            case 3:
                this.addPodcast();
                break;
            case 4:
                this.manageReadingTips();
                break;
            default:
                this.addReadingTip();
                break;
        }
    }

    private void modifyReadingTip() {
        io.print("\nAnna muokattavan lukuvinkin id tai palaa edelliseen "
                + "valikkoon antamalla joku kirjain");
        int id = io.nextInt();

        //Jos syöte ei ole kokonaisluku, io palauttaa -1
        if (id == -1) {
            this.manageReadingTips();
            return;
        }
        ReadingTip tip = tipManager.getReadingTip(id);

        if (tip == null) {
            io.print("Lukuvinkkiä ei löytynyt antamallasi id:llä");
            this.modifyReadingTip();
            return;
        }

        this.printTipDetails(tip);
        io.print("");

        this.doModifications(tip);

        this.manageReadingTips();

    }

    private void doModifications(ReadingTip tip) {
        String field = "";
        while (true) {
            io.print("Anna kenttä jota haluat muokata (vain 'status' toimii)");
            io.print("q lopettaa lukuvinkin muokkaamisen");
            field = io.nextLine();

            if (field.equals("q")) {
                break;
            }

            HashMap<String, TipField> fields = new HashMap<>();
            fields.put("status", new TipStatus(tip));

            TipField fieldToModify = fields.get(field.toLowerCase());

            if (field.equals("status")) {
                if (!tip.getReadStatus()) {
                    tip.setReadStatus(true);
                } else {
                    tip.setReadStatus(false);
                }
            } else {
                io.print("Anna uusi sisältö kentälle " + field);
                String newContent = io.nextLine();
                fieldToModify.setField(newContent);
            }
            ReadingTip updatedTip = null;
            try {
                updatedTip = tipManager.addReadingTip(tip);
            } catch (SQLException ex) {
                io.print(ex + "Lukuvinkin muokkaus epäonnistui");

            }
            this.printTipDetails(updatedTip);
            io.print("Muutokset tallennettu!");
            io.print("");
        }
    }

    private void conditionalSearch() {
        io.print("\nLukuvinkin haku\n\n"
                + "Miten haluat hakea?\n"
                + "1 - Luetut/lukemattomat\n"
                + "2 - Hakutekstin avulla\n"
                + "3 - Palaa lukuvinkkien hallinnointivalikkoon\n");

        int action = io.nextInt();

        switch (action) {
            case 1:
                this.conditionalReadSearch();
                break;
            case 2:
                this.conditionalStringSearch();
            case 3:
                this.addPodcast();
                break;
            default:
                this.addReadingTip();
                break;
        }

    }

    private void conditionalReadSearch() {
        ArrayList<ReadingTip> tips = new ArrayList();
        int searchTip = 0;

        io.print("\nLukuvinkin haku\n\n"
                + "1 - Luetut\n"
                + "2 - Lukemattomat\n");

        searchTip = io.nextInt();

        tips = tipManager.getReadingTipBySelection(searchTip);

        if (tips.size() == 0) {
            io.print("Lukuvinkkejä ei löytynyt antamallasi hakuehdolla");
            this.showReadingTip();
        }

        for (int ind = 0; ind < tips.size(); ind++) {
            this.printTipDetails(tips.get(ind));
        }
        io.print("");

    }

    private void conditionalStringSearch() {
        ArrayList<ReadingTip> tips = new ArrayList();
        String searchTip = "";

        io.print("\nLukuvinkin haku\n\n"
                + "Anna jokin hekuteksti\n");

        searchTip = io.nextLine();

        tips = tipManager.getReadingTipBySearch(searchTip);

        if (tips.size() == 0) {
            io.print("Lukuvinkkejä ei löytynyt antamallasi hakuehdolla");
            this.showReadingTip();
        }

        for (int ind = 0; ind < tips.size(); ind++) {
            this.printTipDetails(tips.get(ind));
        }
        io.print("");

    }

    private void removeReadingTip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addBook() {
        io.print("\nLisää uusi kirjalukuvinkki\n"
                + "Anna ISBN: ");
        String isbn = io.nextLine();

        io.print("\nAnna kirjoittaja: ");
        String author = io.nextLine();

        io.print("\nAnna otsikko: ");
        String title = io.nextLine();

        io.print("\nLisää kommentti: ");
        String comment = io.nextLine();

        io.print("\nLisää tiivistelmä: ");
        String summary = io.nextLine();

        //Luodaan uusi kirjalukuvinkki
        ReadingTip bookTip = new ReadingTip(
                author, title, summary, comment, "Kirja", false
        );

        bookTip.setIsbn(isbn);
        bookTip.setUrl(null);

        this.saveReadingTip(bookTip);

        //Palataan alkuun
        this.start();
    }

    private void addWeb() {
        io.print("\nLisää uusi weblukuvinkki\n"
                + "Anna web-osoite");
        String url = io.nextLine();

        io.print("\nAnna kirjoittaja");
        String author = io.nextLine();

        io.print("\nAnna otsikko");
        String title = io.nextLine();

        io.print("\nLisää tiivistelmä");
        String summary = io.nextLine();

        io.print("\nLisää kommentti");
        String comment = io.nextLine();

        io.print("\nAnna lukuvinkin tyyppi (esim. blogi)");
        String type = io.nextLine();

        ReadingTip webTip = new ReadingTip(author, title, summary, comment,
                type, false);
        webTip.setIsbn(null);
        webTip.setUrl(url);

        this.saveReadingTip(webTip);

        //Palataan alkuun
        this.start();
    }

    private void saveReadingTip(ReadingTip tip) {
        try {
            ReadingTip newTip = tipManager.addReadingTip(tip);
            io.print("");
            io.print("Lukuvinkki tallennettu!");
            io.print("");
            io.print(newTip.toString());
        } catch (SQLException ex) {
            System.out.println("ex: " + ex);
            io.print("Lukuvinkin talletus ei onnistunut");
        }
    }

// Ei ole käytössä vielä
//    private void additionalInfo(ReadingTip readingTip) {
//
//        int action = 0;
//        ArrayList<String> tags = new ArrayList<>();
//        ArrayList<String> preCourses = new ArrayList<>();
//        ArrayList<String> relatedCourses = new ArrayList<>();
//        while (action != 4) {
//            io.print("\n1 - Lisää tagi\n"
//                    + "2 - Lisää esitietokurssi\n"
//                    + "3 - Lisää aiheeseen liittyvä kurssi\n"
//                    + "4 - Valmis\n"
//                    + "5 - Lopeta\n");
//
//            try {
//                action = io.nextInt();
//                io.nextLine();
//                //Ilman tätä tulee kummallinen bugi seuraavassa metodissa 
//            } catch (java.util.InputMismatchException e) {
//                io.nextLine();
//            }
//
//            switch (action) {
//                case 1:
//                    String tag = this.addString("Lisää tagi: ");
//                    tags.add(tag);
//                    break;
//                case 2:
//                    String preCourse = 
//                            this.addString("Lisää esitietokurssi: ");
//                    preCourses.add(preCourse);
//                    break;
//                case 3:
//                    String relatedCourse = this.addString(
//                            "Lisää aiheeseen liittyvä kurssi: "
//                    );
//                    relatedCourses.add(relatedCourse);
//                    break;
//                case 4:
//                //todo: Päivitetään lukuvinkki
//                case 5:
//                    //Palaa aloitusvalikkoon
//                    this.start();
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
    private void addPodcast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

// Ei ole käytössä vielä    
//    private String addString(String headline) {
//        io.print(headline);
//        return io.nextLine();
//    }
    private void printReadingTips() {
        ArrayList<ReadingTip> readingTips = tipManager.getReadingTips();

        String format = "%-5s \t %-20s \t %-50s \t %-10s \t %-10s";
        io.printFormat(format, "ID", "KIRJOITTAJA", "OTSIKKO", "TYYPPI", 
                "STATUS");
        io.print("");
        io.print("-----------------------------------------------------------"
                + "--------------------------------------------------------");
        for (ReadingTip tip : readingTips) {
            String author = tip.getAuthor();
            String title = tip.getTitle();
            String type = tip.getType();
            io.printFormat(format, "" + tip.getId(), author.substring(0, 
                    Math.min(19, author.length())), title.substring(0, 
                    Math.min(49, title.length())), type.substring(0, 
                    Math.min(9, type.length())), tip.getReadStatusString());
            io.print("");
            //io.print(tip.toString());
        }

        this.searchReadingTips();
    }

    private void showReadingTip() {
        io.print("\nAnna lukuvinkin id tai palaa edelliseen "
                + "valikkoon antamalla joku kirjain");
        int id = io.nextInt();

        //Jos syöte ei ole kokonaisluku, io palauttaa -1
        if (id == -1) {
            this.searchReadingTips();
            return;
        }
        ReadingTip tip = tipManager.getReadingTip(id);

        if (tip == null) {
            io.print("Lukuvinkkiä ei löytynyt antamallasi id:llä");
            this.showReadingTip();
            return;
        }

        this.printTipDetails(tip);
        io.print("");

        this.searchReadingTips();
    }

    public static List<String> splitString(String msg, int lineSize) {
        List<String> res = new ArrayList<>();

        Pattern p = Pattern.compile("\\b.{1," + (lineSize - 1) + "}\\b\\W?");
        Matcher m = p.matcher(msg);

        while (m.find()) {   // Debug
            res.add(m.group());
        }
        return res;
    }

    private void printTipDetails(ReadingTip tip) {
        String format = "%-10s \t\t %-15s";
        ArrayList<TipField> fields = new ArrayList<>();
        fields.add(new TipId(tip));
        fields.add(new TipAuthor(tip));
        fields.add(new TipTitle(tip));
        fields.add(new TipType(tip));
        fields.add(new TipIsbn(tip));
        fields.add(new TipUrl(tip));
        fields.add(new TipComment(tip));
        fields.add(new TipStatus(tip));

        for (TipField f : fields) {
            if (!f.isEmpty()) {
                io.printFormat(format, f.getFieldPrint(), f.getField());
                io.print("");
            }
        }

        if (!tip.getSummary().isEmpty()) {
            String summary = tip.getSummary();
            List<String> res = splitString(summary, 40);
            io.printFormat(format, "Tiivistelmä: ", res.get(0));
            io.print("");
            for (int i = 1; i < res.size(); i++) {
                io.printFormat(format, "", res.get(i));
                io.print("");
            }

            io.print("");
        }
//
//        if (tip.getReadingDate() != null) {
//            io.printFormat(format, "Status : ", tip.getAuthor());
//            io.print("");
//        } else {
//            io.printFormat(format, "Status: ", "Ei luettu");
//            io.print("");
//        }
    }

}
