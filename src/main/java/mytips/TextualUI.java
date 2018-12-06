package mytips;

import java.sql.SQLException;
import java.util.*;
import mytips.model.ReadingTip;
import mytips.model.ReadingTipManager;

public class TextualUI {

    private ReadingTipManager tipManager;
    private IO io;

    public TextualUI(ReadingTipManager tipManager, IO io) {
        this.tipManager = tipManager;
        this.io = io;
        io.print("\nTervetuloa lukuvinkkisovellukseen!");
    }

    public void start() throws SQLException {
        io.print("\nMitä haluat tehdä?\n"
                + "1 - Hallinnoi lukuvinkkejä\n"
                + "2 - Selaa lukuvinkkejä\n"
                + "3 - Lopeta\n");

        int action = 0;
        try {
            action = io.nextInt();
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

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

    private void manageReadingTips() throws SQLException {
        io.print("\nLukuvinkkien hallinnointi\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Lisää lukuvinkki\n"
                + "2 - Muokkaa lukuvinkkiä\n"
                + "3 - Poista lukuvinkki\n"
                + "4 - Palaa alkuun\n");

        int action = 0;
        try {
            action = io.nextInt();
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

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

    private void searchReadingTips() throws SQLException {
        io.print("\nLukuvinkkien selaus\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Listaa kaikki lukuvinkit\n"
                + "2 - Näytä yhden lukuvinkin tarkat tiedot\n"
                + "3 - Palaa alkuun\n");

        int action = 0;
        try {
            action = io.nextInt();
            //io.nextLine();
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

        switch (action) {
            case 1:
                this.printReadingTips();
                break;
            case 2:
                this.showReadingTip();
                break;
            case 3:
                this.start();
                break;
            default:
                this.searchReadingTips();
                break;
        }
    }

    private void addReadingTip() throws SQLException {
        io.print("\nLukuvinkin lisäys\n\n"
                + "Minkä lukuvinkin haluat lisätä?\n"
                + "1 - Kirja\n"
                + "2 - Video tai blogipostaus\n"
                + "3 - Podcast\n"
                + "4 - Palaa lukuvinkkien hallinnointivalikkoon\n");

        int action = 0;
        try {
            action = io.nextInt();
            io.nextLine();
            //Ilman tätä tulee kummallinen bugi seuraavassa metodissa 
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void removeReadingTip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addBook() throws SQLException {
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
                author, title, summary, comment, "kirja"
        );

        bookTip.setIsbn(isbn);
        bookTip.setUrl(null);

        this.saveReadingTip(bookTip);

        //Palataan alkuun
        this.start();
    }

    private void addWeb() throws SQLException {
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
                type);
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
    private void printReadingTips() throws SQLException {
        ArrayList<ReadingTip> readingTips = tipManager.getReadingTips();

        String format = "%-5s \t %-20s \t %-50s \t %-10s";
        io.printFormat(format, "ID", "KIRJOITTAJA", "OTSIKKO", "TYYPPI");
        io.print("");
        io.print("-----------------------------------------------------------"
                + "-------------------");
        for (ReadingTip tip : readingTips) {
            io.printFormat(format, "" + tip.getId(), tip.getAuthor(),
                    tip.getTitle(), tip.getType());
            io.print("");
            //io.print(tip.toString());
        }

        this.searchReadingTips();
    }

    private void showReadingTip() throws SQLException {
        int id;
        io.print("\nAnna lukuvinkin id: ");
        try {
            id = io.nextInt();

            //Ilman tätä tulee kummallinen bugi seuraavassa metodissa 
            io.nextLine();

            ReadingTip tip = tipManager.getReadingTip(id);

            if (tip == null) {
                io.print("Lukuvinkkiä ei löytynyt antamallasi id:llä");
                this.showReadingTip();
            }

            this.printTipDetails(tip);
            io.print("");

        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

        this.searchReadingTips();
    }

    private void printTipDetails(ReadingTip tip) {
        String format = "%-8s \t\t %-15s ";
        io.printFormat(format, "Id: ", "" + tip.getId());
        io.print("");
        if (!tip.getAuthor().isEmpty()) {
            io.printFormat(format, "Kirjoittaja: ", tip.getAuthor());
            io.print("");
        }
        if (!tip.getTitle().isEmpty()) {
            io.printFormat(format, "Otsikko: ", tip.getTitle());
            io.print("");
        }
        if (!tip.getType().isEmpty()) {
            io.printFormat(format, "Tyyppi: ", tip.getType());
            io.print("");
        }
        if (tip.getIsbn() != null) {
            io.printFormat(format, "ISBN: ", tip.getIsbn());
            io.print("");
        }
        if (tip.getUrl()!=null) {
            io.printFormat(format, "Url: ", tip.getUrl());
            io.print("");
        }
        if (!tip.getSummary().isEmpty()) {
            io.printFormat(format, "Tiivistelmä: ", tip.getSummary());
            io.print("");
        }
        if (!tip.getComment().isEmpty()) {
            io.printFormat(format, "Kommentti: ", tip.getComment());
            io.print("");
        }
        if (tip.getReadingDate() != null) {
            io.printFormat(format, "Luettu: ", tip.getAuthor());
            io.print("");
        } else {
            io.printFormat(format, "Ei luettu", "");
            io.print("");
        }
    }
}
