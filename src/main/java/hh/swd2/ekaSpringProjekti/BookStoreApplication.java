package hh.swd2.ekaSpringProjekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd2.ekaSpringProjekti.model.Book;
import hh.swd2.ekaSpringProjekti.model.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
		}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookrepository) {
		return (args) -> {
			log.info("save a couple of books");
			bookrepository.save(new Book(24234L,"Johnson, Long", "Long Johnsons stories about long johnsons", "2011", 19.95));
			bookrepository.save(new Book(1234L, "Treehugger", "Nature preservation", "1950", 9.95));
			log.info("find all books");
			for (Book book : bookrepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
