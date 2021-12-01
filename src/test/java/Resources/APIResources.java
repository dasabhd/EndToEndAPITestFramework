package Resources;

//Enum is a special class in Java which has collection of constants or methods

/**
 * The enum Api resources.
 */
public enum APIResources {

    /**
     * Add book api resources.
     */
    AddBook("Library/Addbook.php");
      //GetBook("Library/GetBook.php");

      private String resource;

    APIResources(String resource) {

        this.resource = resource;

    }

    /**
     * Get resource string.
     *
     * @return the string
     */
    public String getResource(){
        return this.resource;
    }
}
