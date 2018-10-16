package hh.swd2.ekaSpringProjekti.webctrl;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd2.ekaSpringProjekti.model.*;

@Controller
public class BookStoreController {
	@Autowired
	private BookRepository bookRepository;
	
	 @Autowired
	    private CategoryRepository categoryRepository;
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getBooks(Model model) {
			//haetaan iedot tietokannasta
		model.addAttribute("books", bookRepository.findAll());
		
		return "booklist";
		
	}
	@RequestMapping(value="/delete/{isbn}",method=RequestMethod.GET)
	public String deteleStudent(@PathVariable("isbn") Long bookISBN) {
			//pyydetään poistamaan tietokannasta yksi opiskelija tietyllä id:llä
			bookRepository.deleteById(bookISBN);	
		return "redirect:../booklist";
	}
	 @RequestMapping(value = "/add")
	    public String addStudent(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", categoryRepository.findAll());
	        return "addbook";
	    }   
		
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        bookRepository.save(book);
	        return "redirect:booklist";
	    }   

	    @RequestMapping(value ="/edit/{isbn}", method = RequestMethod.GET)
	    public String editBook(@PathVariable("isbn") Long bookIsbn, Model model){
	       Book book = findBook(bookIsbn);
	       model.addAttribute("book", book);
	       model.addAttribute("categories", categoryRepository.findAll());

	       return "editbook";
	    }
	    
	    public Book findBook(long isbn){
	        return bookRepository.findById(isbn).get();
	    }

}

