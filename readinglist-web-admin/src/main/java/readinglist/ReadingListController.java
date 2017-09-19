package readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadingListRepository readingListRepository;
    private BookRepository bookRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, BookRepository bookRepository) {
        this.readingListRepository = readingListRepository;
        this.bookRepository = bookRepository;
    }
    
	@RequestMapping(method = RequestMethod.GET)
    public String readersReadingList(Reader reader, Model model) {
        List<ReadingList> readingLists = readingListRepository.findByReader(reader);
        if (readingLists != null) {
            model.addAttribute("readingLists", readingLists);
            model.addAttribute("reader", reader);
        }
        
        return "readingList";
    }
	
	@RequestMapping(value = "/popup", method = RequestMethod.GET)
    public String popup(Reader reader, Model model) {
        return "popup";
    }
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, @RequestParam("isbn10") String isbn10, @RequestParam("isbn13") String isbn13, @RequestParam("title") String title, @RequestParam("author") String author, @RequestParam("review") String review, @RequestParam("rating") float rating) {

		Book book = null;
		if (isbn13 != null && !isbn13.trim().equals("")) {
			book = bookRepository.findByIsbn13(isbn13);
		} else if (isbn10 != null && !isbn10.trim().equals("")) {
			book = bookRepository.findByIsbn10(isbn10);
		}
		
		if (book == null) {
			book = new Book();
		}

		book.setTitle(title);
		book.setAuthor(author);
		book.setIsbn10(isbn10);
		book.setIsbn13(isbn13);
		bookRepository.save(book);
		
		
		ReadingList readingList = readingListRepository.findByReaderAndBook(reader, book);
		
		if(readingList == null){
			readingList = new ReadingList();
		}
		
		readingList.setReader(reader);
		readingList.setRating(rating);
		readingList.setReview(review);
		readingList.setBook(book);
        readingListRepository.save(readingList);
        
        return "redirect:/";
    }

}
