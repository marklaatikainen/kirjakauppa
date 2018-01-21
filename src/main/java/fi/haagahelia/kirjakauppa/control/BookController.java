package fi.haagahelia.kirjakauppa.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.kirjakauppa.model.Book;
import fi.haagahelia.kirjakauppa.model.BookRepository;

import org.springframework.ui.Model;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/booklist")
	public String booklist(Model model) {
		List<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}

	@RequestMapping("/addbook")
	public String add(Model model) {
		model.addAttribute(new Book());
		return "addbook";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../booklist";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		return "login";
	}
	
	@Bean
	public CommandLineRunner addData(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Title", "Author", 2010, "isbn", 0));
			repository.save(new Book("Title", "Author", 2010, "isbn", 0));
			repository.save(new Book("Title", "Author", 2010, "isbn", 0));
			repository.save(new Book("Title", "Author", 2010, "isbn", 0));
		};
	}

}
