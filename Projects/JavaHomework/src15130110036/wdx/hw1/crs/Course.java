package wdx.hw1.crs;

public class Course {
	private String cid;
	private String name;
	private Book[] books;

	public Course(String cid, String name, Book[] books) {
		this.cid = cid;
		this.name = name;
		this.books = books;
	}

	public Book[] getBooks() {
		return this.books;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String bookslist(){
		String list = "";
		for(Book book : books){
			list += "," + book.getName();
		}
		return list.replaceFirst(",", "");
	}
}
