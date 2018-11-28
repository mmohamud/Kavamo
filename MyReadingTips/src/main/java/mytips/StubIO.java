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
    int nextInt;
    int nextString;
    ArrayList<String> outputs;

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
}
