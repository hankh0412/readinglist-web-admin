package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByIsbn10OrIsbn13(String isbn10, String isbn13);
	Book findByIsbn13(String isbn13);
	Book findByIsbn10(String isbn10);
}
