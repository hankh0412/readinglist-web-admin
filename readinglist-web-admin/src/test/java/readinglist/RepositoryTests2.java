package readinglist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class RepositoryTests2 {


    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;


    Book book;
    Reader reader;
    ReadingList readingList;


    @Test
    public void testExample() throws Exception {

        reader = new Reader();
        reader.setUsername("craig");

        //ReadingList r = readingListRepository.findByReaderAndIsbn10OrIsbn13(reader, "", "9788960777330");

        //System.out.println(r.toString());

        //System.out.println(r.getBook().getIsbn10());

    }


    @Test
    public void testExample2() throws Exception {

        book = bookRepository.findByIsbn10OrIsbn13("", "9788960777330");

    }


}