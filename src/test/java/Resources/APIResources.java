package Resources;

//Enum is a special class in Java which has collection of constants or methods

public enum APIResources {

      AddBook("Library/Addbook.php");
      //GetBook("Library/GetBook.php");

      private String resource;

    APIResources(String resource) {

        this.resource = resource;

    }

    public String getResource(){
        return this.resource;
    }
}
