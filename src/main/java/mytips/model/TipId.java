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
public class TipId implements TipField {

    private ReadingTip tip;
    
    public TipId(ReadingTip tip) {
        this.tip = tip;
    }
    
    @Override
    public boolean isEmpty() {
        return (tip.getId() == 0);
    }

    @Override
    public String getField() {
        return Integer.toString(tip.getId());
    }

    @Override
    public void setField(String s) {
        System.out.println("Kenttää id ei voi muuttaa");
    }

    @Override
    public String getFieldPrint() {
        return "Id: ";
    }
    
}
