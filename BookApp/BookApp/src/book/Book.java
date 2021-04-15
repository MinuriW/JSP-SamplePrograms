package book;

public class Book {

	private Integer id;
	private String name;
	private Double price;
	private String author;

	public Book() {
		super();
	}

	public Book(Integer id, String name, Double price, String author) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
