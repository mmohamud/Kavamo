/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips;

/**
 *
 * @author vseppane
 */
public interface IO {
    int nextInt();
    String nextLine();
    void print(String s);
    void printFormat(String format, String... strings);
}
