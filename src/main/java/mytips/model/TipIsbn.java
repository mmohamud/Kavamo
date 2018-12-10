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
public class TipIsbn implements TipField {

    private ReadingTip tip;
    
    public TipIsbn(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getIsbn().isEmpty();
    }

    @Override
    public String getField() {
        return tip.getIsbn();
    }

    @Override
    public void setField(String isbn) {
        tip.setIsbn(isbn);
    }

    @Override
    public String getFieldPrint() {
        return "ISBN: ";
    }
    
}
