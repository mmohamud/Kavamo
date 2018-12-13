/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.io;

import java.util.*;

/**
 *
 * @author vseppane
 */
public class ConsoleIO implements IO {

    private Scanner sc;

    public ConsoleIO() {
        sc = new Scanner(System.in);
    }

    @Override
    public int nextInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public String nextLine() {
        return sc.nextLine();
    }

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void printFormat(
            String format, String... strings) {
        System.out.format(format, (Object[]) strings);
    }

}
