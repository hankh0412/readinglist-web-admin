package readinglist;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ReadingList {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long readinglist_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reader_id")
    private Reader reader;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    
    @Lob
	private String review;
    private float rating;

    
	public Long getReadinglist_id() {
		return readinglist_id;
	}

	public void setReadinglist_id(Long readinglist_id) {
		this.readinglist_id = readinglist_id;
	}

	public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String description) {
        this.review = description;
    }
    
    public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "ReadingList [readinglist_id=" + readinglist_id + ", reader=" + reader + ", book=" + book + ", review="
				+ review + ", rating=" + rating + "]";
	}

}
