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
    
    List<String> stringInputs;
    List<Integer> intInputs;
    int nextInt = 0;
    int nextString = 0;
    ArrayList<String> outputs;

    public StubIO(List<String> stringInputs, List<Integer> intInputs) {
        this.stringInputs = stringInputs;
        this.intInputs = intInputs;
        this.outputs = new ArrayList<>();
    }
    
    @Override
    public int nextInt() {
        int next = intInputs.get(nextInt);
        nextInt++;
        return next;
    }

    @Override
    public String nextLine() {
        String next = stringInputs.get(nextString);
        nextString++;
        return next;
    }

    @Override
    public void print(String s) {
        outputs.add(s);
    }
    
    public ArrayList<String> getPrints() {
        return outputs;
    }
}
