package Exceptions;

public class InvalidArmorException extends Exception { /*exception thrown when an armor cannot be equipped, either if the character is underleveled
                                                        or is a type of hero that cannot equip this type of armor*/

    public InvalidArmorException(String message) {
        super(message);
    }
}
