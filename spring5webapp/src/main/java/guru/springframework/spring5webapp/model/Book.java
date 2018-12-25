package guru.springframework.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String title;
	private String isbn;
	private String publisher;
	
	
	@ManyToMany
	@JoinTable(name="author_book",joinColumns=@JoinColumn(name="books_id"),inverseJoinColumns=@JoinColumn(name="authors_id"))
	private Set<Author> authors = new HashSet<>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title,String isbn,String publisher) {
		this.title=title;
		this.isbn=isbn;
		this.publisher=publisher;
	}
	
	public Book(String title,String isbn,String publisher,Set<Author> authors) {
		this.title=title;
		this.publisher=publisher;
		this.isbn=isbn;
		this.authors=authors;
	}

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
	
	

}
