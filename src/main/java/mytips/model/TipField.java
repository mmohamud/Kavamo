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
public interface TipField {
    boolean isEmpty();
    String getField();
    void setField(String s);
    String getFieldPrint();
}
