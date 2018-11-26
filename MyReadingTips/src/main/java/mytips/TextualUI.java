/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips;

import mytips.model.BookTip;
import java.util.*;

/**
 *
 * @author vseppane
 */
public class TextualUI {

    private ArrayList<BookTip> books;

    public TextualUI() {
        this.books = new ArrayList<>();
        System.out.println("\nTervetuloa lukuvinkkisovellukseen!");
    }

    public void start() {
        System.out.println("\nMitä haluat tehdä?\n"
                + "1 - Hallinnoi lukuvinkkejä\n"
                + "2 - Selaa lukuvinkkejä\n"
                + "3 - Lopeta\n");

        Scanner sc = new Scanner(System.in);
        int action = 0;
        try {
            action = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
        }

        switch (action) {
            case 1:
                this.manageReadingTips();
                break;
            case 2:
                this.searchReadingTips();
                break;
            case 3:
                sc.close();
                break;
            default:
                this.start();
                break;
        }
    }

    private void manageReadingTips() {
        System.out.println("\nLukuvinkkien hallinnointi\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Lisää lukuvinkki\n"
                + "2 - Muokkaa lukuvinkkiä\n"
                + "3 - Poista lukuvinkki\n"
                + "4 - Palaa alkuun\n");

        Scanner sc = new Scanner(System.in);
        int action = 0;
        try {
            action = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addReadingTip() {
        System.out.println("\nLukuvinkin lisäys\n\n"
                + "Minkä lukuvinkin haluat lisätä?\n"
                + "1 - Kirja\n"
                + "2 - Video tai blogipostaus\n"
                + "3 - Podcast\n"
                + "4 - Palaa lukuvinkkien hallinnointivalikkoon\n");

        Scanner sc = new Scanner(System.in);
        int action = 0;
        try {
            action = sc.nextInt();
        } catch (java.util.InputMismatchException e) {
            sc.nextLine();
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
        Scanner sc = new Scanner(System.in);
        System.out.println("\nLisää uusi kirjalukuvinkki\n"
                + "Anna ISBN: ");
        String isbn = "";
        isbn += sc.nextLine();

        System.out.println("\nAnna kirjoittaja: ");
        String author = "";
        author += sc.nextLine();

        System.out.println("\nAnna otsikko: ");
        String title = "";
        title += sc.nextLine();

        System.out.println("\nLisää kommentti: ");
        String comment = "";
        comment = sc.nextLine();

        System.out.println("\nLisää tiivistelmä: ");
        String summary = "";
        summary = sc.nextLine();

        int action = 0;
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> preCourses = new ArrayList<>();
        ArrayList<String> relatedCourses = new ArrayList<>();
        while (action != 4) {
            System.out.println("\n1 - Lisää tagi\n"
                    + "2 - Lisää esitietokurssi\n"
                    + "3 - Lisää aiheeseen liittyvä kurssi\n"
                    + "4 - Valmis\n");

            try {
                action = sc.nextInt();
            } catch (java.util.InputMismatchException e) {
                sc.nextLine();
            }
            
            switch (action) {
                case 1:
                    String tag = "";
                    tag += this.addString("Lisää tagi: ");
                    tags.add(tag);
                    break;
                case 2:
                    String preCourse = "";
                    preCourse = this.addString("Lisää esitietokurssi: ");
                    preCourses.add(preCourse);
                    break;
                case 3:
                    String relatedCourse = "";
                    relatedCourse
                            = this.addString("Lisää aiheeseen liittyvä kurssi: ");
                    relatedCourses.add(relatedCourse);
                    break;
                case 4:
                    //Luodaan uusi kirjalukuvinkki
                    BookTip bookTip
                            = new BookTip(1, author, title, isbn, summary, comment);
                    books.add(bookTip);
                    System.out.println("\nKirja tallennettu tietokantaan!");
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
        Scanner sc = new Scanner(System.in);
        System.out.println(headline);
        return sc.nextLine();
    }
}
