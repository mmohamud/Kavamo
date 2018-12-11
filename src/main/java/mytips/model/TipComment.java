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
public class TipComment implements TipField {
    
    private ReadingTip tip;
    
    public TipComment(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getComment().isEmpty();
    }

    @Override
    public String getField() {
        return tip.getComment();
    }

    @Override
    public void setField(String comment) {
        tip.setComment(comment);
    }

    @Override
    public String getFieldPrint() {
        return "Kommentti: ";
    }
}
