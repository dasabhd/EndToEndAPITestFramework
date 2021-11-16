package Resources;

import POJO.LibraryPayload;

public class TestDataBuild {

    public LibraryPayload addPlaceBuild(String name, String isbn, String aisle, String author){

        LibraryPayload lp = new LibraryPayload();
        lp.setName(name);
        lp.setIsbn(isbn);
        lp.setAisle(aisle);
        lp.setAuthor(author);

        return lp;
    }

}
