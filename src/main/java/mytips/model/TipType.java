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
public class TipType implements TipField {
    
    private ReadingTip tip;
    
    public TipType(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getType().isEmpty();
    }

    @Override
    public String getField() {
        return tip.getType();
    }

    @Override
    public void setField(String type) {
        tip.setType(type);
    }

    @Override
    public String getFieldPrint() {
        return "Tyyppi: ";
    }
}
