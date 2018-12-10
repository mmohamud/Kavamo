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
public class TipStatus implements TipField {

    private ReadingTip tip;

    public TipStatus(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String getField() {
        if (tip.readStatus()) {
            return "Luettu";
        } else {
            return "Ei luettu";
        }
    }

    @Override
    public void setField(String status) {
        tip.setReadStatus(true);
    }

    @Override
    public String getFieldPrint() {
        return "Status: ";
    }
}
