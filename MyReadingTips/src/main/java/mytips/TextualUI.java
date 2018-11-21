/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips;

import java.util.*;

/**
 *
 * @author vseppane
 */
public class TextualUI {

    private static Scanner scanner;

    public TextualUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("\nTervetuloa lukuvinkkisovellukseen!\n");
        System.out.println("Mitä haluat tehdä?\n"
                + "1 - Hallinnoi lukuvinkkejä\n"
                + "2 - Selaa lukuvinkkejä\n"
                + "3 - Lopeta\n");

        int action = scanner.nextInt();

        switch (action) {
            case 1:
                this.manageReadingTips();
                break;
            case 2:
                this.searchReadingTips();
                break;
            default:
                break;
        }
    }

    private void manageReadingTips() {
        System.out.println("Lukuvinkkien hallinnointi\n\n"
                + "Mitä haluat tehdä?\n"
                + "1 - Lisää lukuvinkki\n"
                + "2 - Muokkaa lukuvinkkiä\n"
                + "3 - Poista lukuvinkki\n"
                + "4 - Palaa alkuun\n");

        int action = scanner.nextInt();

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
                break;
        }
    }

    private void searchReadingTips() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void addReadingTip() {
        System.out.println("Lukuvinkin lisäys\n\n"
                + "Minkä lukuvinkin haluat lisätä?\n"
                + "1 - Kirja\n"
                + "2 - Video tai blogipostaus\n"
                + "3 - Podcast\n"
                + "4 - Palaa lukuvinkkien hallinnointivalikkoon\n");

        int action = scanner.nextInt();

        if (action == 1) {
            this.addBook();
        } else if (action == 2) {
            this.addUrlTip();
        } else if (action == 3) {
            this.addPodcast();
        } else if (action == 4) {
            this.manageReadingTips();
        }
    }

    private void modifyReadingTip() {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    private void removeReadingTip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addBook() {
        System.out.println("Lisää uusi kirjalukuvinkki\n"
                + "Anna ISBN: ");
        String isbn = scanner.next();

        System.out.println("Anna kirjoittaja: ");
        String author = scanner.next();

        System.out.println("Anna otsikko: ");
        String title = scanner.next();

        System.out.println("Lisää kommentti: ");
        String comment = scanner.next();
        
        System.out.println("Lisää tiivistelmä: ");
        String  summary = scanner.next();
        
        int action = 0;
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> prerequisiteCourses = new ArrayList<>();
        ArrayList<String> relatedCourses = new ArrayList<>();
        while (action != 4) {
            System.out.println("1 - Lisää tagi\n"
                    + "2 - Lisää esitietokurssi\n"
                    + "3 - Lisää aiheeseen liittyvä kurssi\n"
                    + "4 - Valmis\n");

            action = scanner.nextInt();

            if (action == 1) {
                String tag = this.addString("Lisää tagi: ");
                tags.add(tag);
            } else if (action == 2) {
                String prerequisiteCourse = 
                    this.addString("Lisää esitietokurssi: ");
                prerequisiteCourses.add(prerequisiteCourse);
            } else if (action == 3) {
                String relatedCourse = 
                    this.addString("Lisää aiheeseen liittyvä kurssi: ");
                relatedCourses.add(relatedCourse);
            } else if (action == 4) {
                return;
            }
        }
        
        //Luodaan uusi kirjalukuvinkki
        //BookTip bookTip = 
            //new BookTip("1", author, title, isbn, summary, comment,
        //    tags, prerequisiteCourses, relatedCourses);
    }

    private void addUrlTip() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void addPodcast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String addString(String headline) {
        System.out.println(headline);
        return scanner.next();
    }
}
