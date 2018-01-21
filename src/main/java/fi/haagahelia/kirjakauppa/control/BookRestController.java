package fi.haagahelia.kirjakauppa.control;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fi.haagahelia.kirjakauppa.model.Book;
import fi.haagahelia.kirjakauppa.model.BookRepository;

@RestController
public class BookRestController {
	@Autowired
	private BookRepository repository;

	@OneToMany
	@JsonIgnore
	@RequestMapping(value = "/api/booklist", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	@RequestMapping(value = "/api/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book findBookRest(@PathVariable("id") Long	bookId) {
		return repository.findOne(bookId);
	}
}
