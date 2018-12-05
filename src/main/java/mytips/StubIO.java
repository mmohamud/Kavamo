/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips;

import java.util.*;

/**
 *
 * @author vseppane
 */
public class StubIO implements IO {
    
    private List<String> stringInputs;
    private List<Integer> intInputs;
    private int nextInt;
    private int nextString;
    private ArrayList<String> outputs;

    public StubIO(List<String> stringInputs, List<Integer> intInputs) {
        this.stringInputs = stringInputs;
        this.intInputs = intInputs;
        this.outputs = new ArrayList<>();
    }
    
    @Override
    public int nextInt() {
        return intInputs.get(nextInt++);
    }

    @Override
    public String nextLine() {
        return stringInputs.get(nextString++);
    }

    @Override
    public void print(String s) {
        outputs.add(s);
    }
    
    public ArrayList<String> getPrints() {
        return outputs;
    }

    @Override
    public void printTipFormat(String s, String id, String author, String title, String type) {
        outputs.add(id + " " + author + " " + title + " " + type);
    }
}
