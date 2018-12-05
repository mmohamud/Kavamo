/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytips.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mytips.model.BookTip;

/**
 *
 * @author vseppane
 */
public class InMemoryBookTipDao implements Dao {

    private ArrayList<BookTip> bookTips = new ArrayList<>();

    public InMemoryBookTipDao() {
        bookTips.add(new BookTip(20, "Robert Martin", "Clean Code: A Handbook of Agile Software Craftsmanship", "", "", "978-0132350884", "kirja"));
        bookTips.add(new BookTip(21, "Margaret Atwood", "Orjattaresi", "", "Margaret Atwoodin Orjattaresi on vavahduttava dystopia lähitulevaisuuden Yhdysvalloista, jossa vanhatestamentilliset fundamentalistit ovat ottaneet vallan. Yli 30 vuotta ensijulkaisunsa jälkeen romaanin teemat vapaudesta ja naisten oikeuksista ovat nyt ajankohtaisempia kuin koskaan. Margaret Atwood on kanadalainen kirjailija, joka on pitkän uransa aikana kirjoittanut yli 40 teosta ja saanut useita merkittäviä kirjallisuuspalkintoja.", "9780770422639", "kirja"));
    }

    @Override
    public Object findOne(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List findAll() throws SQLException {
        return bookTips;
    }

    @Override
    public Object saveOrUpdate(Object object) throws SQLException {
        BookTip bookTip = (BookTip) object;
        bookTips.add(bookTip);
        return bookTip;
    }

    @Override
    public void delete(Object key) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object findOneById(int key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
