package Resources;

import POJO.LibraryPayload;

/**
 * The type Test data build.
 */
public class TestDataBuild {

    /**
     * Add place build library payload.
     *
     * @param name   the name
     * @param isbn   the isbn
     * @param aisle  the aisle
     * @param author the author
     * @return the library payload
     */
    public LibraryPayload addPlaceBuild(String name, String isbn, String aisle, String author){

        LibraryPayload lp = new LibraryPayload();
        lp.setName(name);
        lp.setIsbn(isbn);
        lp.setAisle(aisle);
        lp.setAuthor(author);

        return lp;
    }

}
