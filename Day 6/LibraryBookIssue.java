class Book{
    private String title;
    private boolean isIssued;

    public Book(String title){
        this.title =title;
        this.isIssued =false;
    }

    public void issuedBook(){
        if(!isIssued){
            isIssued =true;
            System.out.println("Book" + title + " has been issued Successfully");
            }
            else{
                System.out.println("Book"+ title + " Is already issued so cannot issue again");
                }
            }
            public void returnBook(){
                if(isIssued){
                    isIssued =false;
                    System.out.println("Book :" + title + " has been retun successfully");
                }
                else{
                    System.out.println("Book :" + title + " was not issued, so it cannot be returned");
                }
            }
                public void displayStatus(){
                    System.out.println(" Book : " + title + " | Issued : " + isIssued);
                }
            }
            public class LibraryBookIssue{
                public static void main(String[] args) {
                    Book book1 =new Book(" Embedded System ");
                    Book book2 =new Book(" Java ");


                    book1.issuedBook();
                    book1.returnBook();
                    book2.issuedBook();
                    book2.returnBook();
                }
            }
            
