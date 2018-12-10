/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

/**
 *
 * @author vseppane
 */
public class TipAuthor implements TipField {

    private ReadingTip tip;
    
    public TipAuthor(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getAuthor().isEmpty();
    }

    @Override
    public String getField() {
        return tip.getAuthor();
    }

    @Override
    public void setField(String author) {
        tip.setAuthor(author);
    }

    @Override
    public String getFieldPrint() {
        return "Kirjoittaja: ";
    }
    
}
