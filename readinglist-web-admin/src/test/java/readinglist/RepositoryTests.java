package readinglist;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReadingListRepository readingListRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ReaderRepository readerRepository;
    
    
    Book book;
    Reader reader;
    ReadingList readingList;
    
    
    @Before
	public void setUp() {
    	

		reader = new Reader();
    	reader.setUsername("username");
    	reader.setPassword("password");
    	readerRepository.save(reader);
    	
    	book = new Book();
		book.setTitle("title");
		book.setAuthor("author");
		book.setIsbn10("isbn10");
		book.setIsbn13("isbn13");
		
    	readingList = new ReadingList();
		readingList.setReader(reader);
		readingList.setRating(3);
		readingList.setReview("review");
		readingList.setBook(book);
		
		readingListRepository.save(readingList);

	}


    @Test
    public void testExample() throws Exception {
       //this.entityManager.persist(new User("sboot", "1234"));
       // User user = this.repository.findByUsername("sboot");
       // assertThat(user.getUsername()).isEqualTo("sboot");
       // assertThat(user.getVin()).isEqualTo("1234");
    	
    	
        //List<ReadingList> readingLists = readingListRepository.findByReader(reader);
    	
    	//readingLists.forEach(System.out::println);
    	
    }
    

}