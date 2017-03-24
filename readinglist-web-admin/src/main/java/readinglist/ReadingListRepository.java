package readinglist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {
	
	@Query("select rl from ReadingList rl join fetch rl.book where rl.reader = ?1")
    List<ReadingList> findByReader(Reader reader);
	
	
    ReadingList findByReaderAndBook(Reader reader, Book book);
	
}
