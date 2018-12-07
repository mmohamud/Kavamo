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
public class TipTitle implements TipField {

    ReadingTip tip;
    
    public TipTitle(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getTitle().isEmpty();
    }

    @Override
    public String getField() {
        return tip.getTitle();
    }

    @Override
    public void setField(String title) {
        tip.setTitle(title);
    }

    @Override
    public String getFieldPrint() {
        return "Otsikko: ";
    }
    
}
