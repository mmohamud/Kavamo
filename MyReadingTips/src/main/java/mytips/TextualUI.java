/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips;

import mytips.model.BookTip;
import java.util.*;
import mytips.model.ReadingTip;
import mytips.model.TipManager;

/**
 *
 * @author vseppane
 */
public class TextualUI {

    private ArrayList<BookTip> books;
    private TipManager tipManager;
    private IO io;

    public TextualUI(TipManager tipManager, IO io) {
        this.books = new ArrayList<>();
        this.tipManager = tipManager;
        this.io = io;
        io.print("\nTervetuloa lukuvinkkisovellukseen!");
    }

    public void start() {
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

    private void manageReadingTips() {
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

    private void searchReadingTips() {
        io.print("\nLukuvinkkien selaus\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Listaa kaikki lukuvinkit\n"
                + "2 - Palaa alkuun\n");

        int action = 0;
        try {
            action = io.nextInt();
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

        switch (action) {
            case 1:
                this.printReadingTips();
                break;
            case 2:
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

        int action = 0;
        try {
            action = io.nextInt();
            io.nextLine(); //Ilman tätä tulee kummallinen bugi seuraavassa metodissa 
        } catch (java.util.InputMismatchException e) {
            io.nextLine();
        }

        switch (action) {
            case 1:
                this.addBook();
                break;
            case 2:
                this.addUrlTip();
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

        int action = 0;
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> preCourses = new ArrayList<>();
        ArrayList<String> relatedCourses = new ArrayList<>();
        while (action != 4) {
            io.print("\n1 - Lisää tagi\n"
                    + "2 - Lisää esitietokurssi\n"
                    + "3 - Lisää aiheeseen liittyvä kurssi\n"
                    + "4 - Valmis\n");

            try {
                action = io.nextInt();
                io.nextLine(); //Ilman tätä tulee kummallinen bugi seuraavassa metodissa 
            } catch (java.util.InputMismatchException e) {
                io.nextLine();
            }

            switch (action) {
                case 1:
                    String tag = this.addString("Lisää tagi: ");
                    tags.add(tag);
                    break;
                case 2:
                    String preCourse = this.addString("Lisää esitietokurssi: ");
                    preCourses.add(preCourse);
                    break;
                case 3:
                    String relatedCourse = 
                            this.addString("Lisää aiheeseen liittyvä kurssi: ");
                    relatedCourses.add(relatedCourse);
                    break;
                case 4:
                    //Luodaan uusi kirjalukuvinkki
                    BookTip bookTip
                            = new BookTip(1, author, title, summary, comment, isbn);
                    books.add(bookTip);
                    io.print("\n");
                    io.print("Kirja tallennettu!");
                    books.get(books.size() - 1).print();

                    //Palaa aloitusvalikkoon
                    this.start();
                    break;
                default:
                    break;
            }
        }
    }

    private void addUrlTip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addPodcast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String addString(String headline) {
        io.print(headline);
        return io.nextLine();
    }

    private void printReadingTips() {
        tipManager.printReadingTips();
        this.searchReadingTips();
    }
}
