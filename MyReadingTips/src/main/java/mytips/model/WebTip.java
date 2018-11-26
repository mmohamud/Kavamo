/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

/**
 *
 * @author mmohamud
 */

public class WebTip extends ReadingTip {

    public WebTip(String url, int id, String author, String title, 
            String summary, String comment) {
        super(id, author, title, summary, comment, "web");
    }

}
