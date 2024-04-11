package pkg_main;

import java.util.Scanner;

import library_management.Book;
import library_management.BookManager;
import pkg_exception.BookNotFoundException;
import pkg_exception.StudentNotFoundException;
import pkg_person.Student;
import pkg_person.Student_Manager;
import pkg_transaction.Book_Transaction_Manager;

public class Main {
	public static void main(String[] args) throws StudentNotFoundException {
		int choice;
		Scanner sc=new Scanner(System.in);
		
		BookManager bm=new BookManager();
		Student_Manager sm=new Student_Manager();
		Book_Transaction_Manager btm=new Book_Transaction_Manager();
		
		do {
			System.out.println("Enter 1 if Student\nEnter 2 if Librarian\nEnter 3 if want to exit");
			choice= sc.nextInt();
			
			if(choice==1)//if user is student
			{
				System.out.println("Enter Your Roll Number");
				int rollNo=sc.nextInt();
				try {
					Student s=sm.get(rollNo);
					if(s==null)
						throw new StudentNotFoundException();
					int stud_choice;
					do {
						System.out.println("Enter 1 to View All Books\n\nEnter 2 to search Book by ISBN\n\nEnter 3 to List Books by Subject\n\nEnter 4 to Issue a Book\n\nEnter 5 to Return a Book\n\nEnter 99 to Exit");
						stud_choice=sc.nextInt();
						switch(stud_choice) {
						case 1:
							System.out.println("All the Book Records are");
							bm.viewAllBooks();
							break;
						case 2:
							System.out.println("Please Enter ISBN to Search");
							int search_isbn;
							System.out.println("Enter ISBN of the book to search");
							search_isbn=sc.nextInt();
							Book book=bm.searchBookByIsbn(search_isbn);
							if(book==null)
								System.err.println("No Book with this ISBN Exists in Our Library");
							else
								System.err.println(book);
							break;
						case 3:
							System.out.println("Enter the Subject");
							sc.nextLine();
							String search_subject=sc.nextLine();
							bm.listBookBySubject(search_subject);
							break;
						case 4:
							System.out.println("Enter the ISBN to Issue a Book");
							int issue_isbn=sc.nextInt();
							book=bm.searchBookByIsbn(issue_isbn);
							try {
								if(book==null) {
									throw new BookNotFoundException();
								}
								if(book.getAvailable_quantity()>0) {
									if(btm.issueBook(rollNo, issue_isbn)) {
										book.setAvailable_quantity(book.getAvailable_quantity()-1);
										System.out.println("Book has been Issued");
									}
								}
								else {
									System.out.println("The Book has been Issued...");
								}
							}
							catch(BookNotFoundException bnfe) {
								System.out.println(bnfe);
							}
							break;
						case 5:
							System.out.println("Please Enter the ISBN to Return a Book");
							int return_isbn=sc.nextInt();
							book=bm.searchBookByIsbn(return_isbn);
							if(book!=null) {
								if(btm.returnBook(rollNo, return_isbn)) {
									book.setAvailable_quantity(book.getAvailable_quantity()+1);
									System.out.println("Thank you for the returning the book");
								}
								else {
									System.out.println("Could not return the book");
								}
							}
							else
								System.out.println("Book with this ISBN does not Exists ");
							break;
						case 99:
							System.out.println("Thank you for using Library");
							break;
						default:
							System.out.println("Invalid Choice");
						}
					} while (stud_choice!=99);
				}
				catch(StudentNotFoundException snfe) {
					System.out.println(snfe);
				}
			}
			else if(choice==2)//user is a librarian
			{
				int lib_choice;
				do {
				
				System.out.println("Enter 11 to view all Students\n\nEnter 12 to Print a Student by Roll Number\n\nEnter 13 to Register a Student\n\nEnter 14 to Update a Student\n\nEnter 15 to Delete a Student\n");
				System.out.println("Enter 21 to view all Books\n\nEnter 22 to Print a Book by ISBN\n\nEnter 23 to Add a New Book\n\nEnter 24 to Update a Book\n\nEnter 25 to Delete a Book\n");
				System.out.println("Enter 31 to view all Transactions\n");
				System.out.println("Enter 99 to Exit");
				lib_choice=sc.nextInt();
				switch(lib_choice) {
				case 11://view all students
					System.out.println("All the Students Records");
					sm.viewAllStudents();
					break;
				case 12://search a student based on roll number
					System.out.println("Enter Roll Number to Search Student's Record");
					int get_rollNo=sc.nextInt();
					Student student=sm.get(get_rollNo);
					if(student==null) {
						System.err.println("No Record Matches this Roll Number");
					}
					else
						System.err.println(student);
					break;
				case 13://Adding a student
					System.out.println("Enter Students Details to Add");
					String name;
					String emailid; 
					String phoneNumber; 
					String address; 
					String dob;
					int rollNo; 
					int std;
					String divison;
					sc.nextLine();
					System.out.println("Name");
					name=sc.nextLine();
					System.out.println("EmailId");
					emailid=sc.nextLine();
					System.out.println("phoneNumber");
					phoneNumber=sc.nextLine();
					System.out.println("address");
					address=sc.nextLine();
					System.out.println("Date of Birth");
					dob=sc.nextLine();
					System.out.println("Roll Number as Integer");
					rollNo=sc.nextInt();
					System.out.println("Standard as Integer");
					std=sc.nextInt();
					sc.nextLine();
					System.out.println("Divison");
					divison=sc.nextLine();
					student=new Student(name,emailid,phoneNumber,address,dob,rollNo,std,divison);
					sm.addAStudent(student);
					System.err.println("Student is Added");
					break;
				case 14://Update a student
					System.out.println("Enter the Roll number to modify the Record");
					int modify_rollno;
					modify_rollno=sc.nextInt();
					student=sm.get(modify_rollno);
					try {
					if(student==null)
						throw new StudentNotFoundException();
					sc.nextLine();
					System.out.println("Name");
					name=sc.nextLine();
					System.out.println("EmailId");
					emailid=sc.nextLine();
					System.out.println("phoneNumber");
					phoneNumber=sc.nextLine();
					System.out.println("address");
					address=sc.nextLine();
					System.out.println("Date of Birth");
					dob=sc.nextLine();
					System.out.println("Standard as Integer");
					std=sc.nextInt();
					sc.nextLine();
					System.out.println("Divison");
					divison=sc.nextLine();
					sm.update_Student(modify_rollno, name, emailid, phoneNumber, address, dob, std, divison);
					System.err.println("Student record is Updated");
					}
					catch(StudentNotFoundException snfe) {
						System.err.println(snfe);
					}
					break;
				case 15://to delete student
					System.out.println("Enter the Roll number to delete the Record");
					int delete_rollno;
					delete_rollno=sc.nextInt();
					if(sm.deleteStudent(delete_rollno))
						System.err.println("Student record is removed");
					else
						System.err.println("NO record with given roll no exists");
					break;
				case 21://view all books
					bm.viewAllBooks();
					break;
				case 22://search book by isbn
					int search_isbn;
					System.out.println("Enter ISBN of the book to search");
					search_isbn=sc.nextInt();
					Book book=bm.searchBookByIsbn(search_isbn);
					if(book==null)
						System.err.println("No Book with this ISBN Exists in Our Library");
					else
						System.err.println(book);
					break;
				case 23://add a book
					System.out.println("Please Enter Book Details to Add");
					int isbn;
					String author;
					String title;
					String publisher;
					int edition;
					String subject;
					int available_quantity;
					
					System.out.println("ISBN");
					isbn=sc.nextInt();
					
					sc.nextLine();
					System.out.println("Title");
					title=sc.nextLine();
					
					System.out.println("Author");
					author=sc.nextLine();
					
					System.out.println("Publisher");
					publisher=sc.nextLine();
					
					System.out.println("Edition");
					edition=sc.nextInt();
					
					sc.nextLine();
					System.out.println("Subject");
					subject=sc.nextLine();
					
					System.out.println("Quantity");
					available_quantity=sc.nextInt();
					
					book=new Book(isbn,author,title, publisher,edition, subject,
							available_quantity);
					bm.addABook(book);
					System.err.println("A Book Record is Added");
					break;
				case 24://update a record of book
					System.out.println("Please enter the ISBN to update the record");
					int update_isbn;
					update_isbn=sc.nextInt();
					try {
						book =bm.searchBookByIsbn(update_isbn);
						if(book==null)
							throw new BookNotFoundException();
						System.out.println("Enter Book Deatails to Modify");
						sc.nextLine();
						System.out.println("Title");
						title=sc.nextLine();
						
						System.out.println("Author");
						author=sc.nextLine();
						
						System.out.println("Publisher");
						publisher=sc.nextLine();
						
						System.out.println("Edition");
						edition=sc.nextInt();
						
						sc.nextLine();
						System.out.println("Subject");
						subject=sc.nextLine();
						
						System.out.println("Quantity");
						available_quantity=sc.nextInt();
						
						bm.updateBook(update_isbn, author, title, publisher, edition, subject, available_quantity);
					}
					catch(BookNotFoundException bnfa){
						System.out.println(bnfa);
					}
					break;
				case 25://delete a record of book
					System.out.println("Please enter the ISBN to update the record");
					int delete_isbn;
					delete_isbn=sc.nextInt();
					try {
						book =bm.searchBookByIsbn(delete_isbn);
						if(book==null)
							throw new BookNotFoundException();
						bm.deleteBook(delete_isbn);
						System.out.println("Book Record is Deleted");}
					catch(BookNotFoundException bnfe) {
						System.out.println(bnfe);
					}
					break;
				case 31://to View all Transactions
					System.out.println("All the Transactions are ");
					btm.showAll();
					break;
				case 99:
					System.err.println("Thank You for using Library ");
					break;
				default:
					System.err.println("Invalid Choice");
				}
				}while(lib_choice!=99);
			}
			
		}while(choice !=3);
		System.err.println("You are exit from the Library Management System");
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
	}
}