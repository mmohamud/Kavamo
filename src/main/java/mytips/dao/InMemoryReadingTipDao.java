/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytips.model.ReadingTip;

/**
 *
 * @author vseppane
 */
public class InMemoryReadingTipDao implements Dao {

    private ArrayList<ReadingTip> readingTips = new ArrayList<>();

    public InMemoryReadingTipDao() {
        readingTips.add(new ReadingTip(
                "Robert Martin", "Clean Code: A Handbook of Agile "
                + "Software Craftsmanship", 
                "Even bad code can function. But if code isn't clean, "
                + "it can bring a development organization to its knees.",
                "kiinnostava kirja hyvästä koodista", "kirja"));
        readingTips.add(new ReadingTip("Margaret Atwood", "Orjattaresi", 
                "Margaret Atwoodin Orjattaresi on vavahduttava dystopia "
                + "lähitulevaisuuden Yhdysvalloista, jossa "
                + "vanhatestamentilliset "
                + "fundamentalistit ovat ottaneet vallan.Yli 30 vuotta "
                + "ensijulkaisunsa jälkeen romaanin teemat vapaudesta ja "
                + "naisten oikeuksista ovat nyt ajankohtaisempia kuin koskaan.",
                "", "kirja"));
        readingTips.add(new ReadingTip("Nicola Apicella",
                "Consistency models", "", "", "blogpost"));
        readingTips.add(new ReadingTip("", "Merge sort algorithm", "",
                "Hyvä selitys merge sortin toiminnasta esimerkin avulla", 
                "video"));
        readingTips.get(0).setIsbn("978-0-13-235088-4");
    }

    @Override
    public Object findOne(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() throws SQLException {
        return readingTips;
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        ReadingTip readingTip = (ReadingTip) object;
        readingTips.add(readingTip);
        return readingTip;
    }

    @Override
    public void delete(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOneById(int key) throws SQLException {
        if (key <= readingTips.size()) {
            return readingTips.get(key - 1);
        } else {
            return null;
        }
    }
}
