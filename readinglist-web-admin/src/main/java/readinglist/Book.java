package readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    
    private String isbn10;
	private String isbn13;
    private String title;
    private String author;
    
    
    public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getIsbn10() {
		return isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", isbn10=" + isbn10 + ", isbn13=" + isbn13 + ", title=" + title
				+ ", author=" + author + "]";
	}


}
