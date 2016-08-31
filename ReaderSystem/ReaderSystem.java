import java.util.Set;

public class ReaderSystem
{
    private Book b;
    private User u;
    
    public ReaderSystem(Book b, User u) { }
    public void listenRequest() { }
    public Book searchBook(long ID) { return Book.find(ID); }
    public User searchUser(long ID) { return User.find(ID); }
    public void display() { }
}

class Book
{
    private long ID;
    private String details;
    private static Set<Book> books;
    
    public Book(long iD, String details) { }
    
    public static void addBook(long iD, String details)
    {
        books.add(new Book(iD, details));
    }
    
    public void update() { }
    
    public static void delete(Book b)
    {
        books.remove(b);
    }
    
    public static Book find(long iD)
    {
        for (Book b : books)
        {
            if (Book.getID(b) == iD)
            {
                return b;
            }
        }
        return null;
    }
    
    public static long getID(Book b) { return b.ID; }
}

class User
{
    private long ID;
    private String details;
    private int accountType;
    private static Set<User> users;
    
    public Book searchLibrary(long iD) { return Book.find(iD); }
    public void renewMembership() { }
    
    public static User find(long iD)
    {
        for (User u : users)
        {
            if (User.getID(u) == iD)
            {
                return u;
            }
        }
        return null;
    }
    
    public static void addUser(long iD, String details, int accountType)
    {
        users.add(new User(iD, details, accountType));
    }
    
    public User(long iD, String details, int accountType) { }
    
    public static long getID(User u) { return u.ID; }
}











