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
public class TipUrl implements TipField {
    
    private ReadingTip tip;
    
    public TipUrl(ReadingTip tip) {
        this.tip = tip;
    }

    @Override
    public boolean isEmpty() {
        return tip.getUrl() == null;
    }

    @Override
    public String getField() {
        return tip.getUrl();
    }

    @Override
    public void setField(String url) {
        tip.setUrl(url);
    }

    @Override
    public String getFieldPrint() {
        return "Url: ";
    }
    
}
