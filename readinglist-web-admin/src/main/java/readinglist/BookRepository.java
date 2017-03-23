package readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByIsbn10OrIsbn13(String isbn10, String isbn13);
}
