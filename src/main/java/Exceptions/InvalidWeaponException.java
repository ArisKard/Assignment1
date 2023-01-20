package Exceptions;

public class InvalidWeaponException extends Exception { /*exception thrown when a weapon cannot be equipped, either if the character is underleveled
                                                        or is a type of hero that cannot equip this type of weapon*/

    public InvalidWeaponException(String message) {
        super(message);
    }
}
