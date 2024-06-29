package org.lorenzo.eserciziopet.exception;


public class AnimaleNotFoundException extends RuntimeException {
    public AnimaleNotFoundException(Long id) {
        super("Pet not found with id: " + id);
    }
}
