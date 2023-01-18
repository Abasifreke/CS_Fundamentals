package FourInARow.Exceptions;

public class ColumnFullException extends ArrayIndexOutOfBoundsException {

    public ColumnFullException(String errMessage) {
        super(errMessage);
    }
}
