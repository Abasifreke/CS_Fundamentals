package FourInARow.Exceptions;

public class InvalidMoveException extends ArrayIndexOutOfBoundsException {

    public InvalidMoveException(String errMessage) {
        super(errMessage);
    }
}
