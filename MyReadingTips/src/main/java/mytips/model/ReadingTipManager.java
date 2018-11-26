/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.model;

import java.util.*;

/**
 *
 * @author vseppane
 */
public class ReadingTipManager implements TipManager {

    private ArrayList<ReadingTip> readingTips;

    public ReadingTipManager() {
        //Haetaanko lukuvinkit tässä kohtaa tietokannasta?

        readingTips = new ArrayList<>();
    }

    @Override
    public void addReadingTip(ReadingTip readingTip) {
        //to do: lukuvinkin lisäys tietokantaan

        this.readingTips.add(readingTip);
    }

    @Override
    public ArrayList<ReadingTip> getReadingTips() {
        return readingTips;
    }
}
