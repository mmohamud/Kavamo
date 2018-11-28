/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.util.ArrayList;
import mytips.IO;

/**
 *
 * @author vseppane
 */
public class StubManager implements TipManager {

    private ArrayList<ReadingTip> readingTips;
    private IO io;

    public StubManager(ArrayList<ReadingTip> readingTips, IO io) {
        this.readingTips = readingTips;
        this.io = io;
    }

    @Override
    public ArrayList<ReadingTip> getReadingTips() {
        return readingTips;
    }

    @Override
    public void printReadingTips() {
        for (ReadingTip tip : readingTips) {
            io.print(tip.toString() + "\n");
        }
    }

    @Override
    public void addBookTip(BookTip readingTip) {
        readingTips.add(readingTip);
    }

    @Override
    public void addWebTip(WebTip readingTip) {
        readingTips.add(readingTip);
    }

}
