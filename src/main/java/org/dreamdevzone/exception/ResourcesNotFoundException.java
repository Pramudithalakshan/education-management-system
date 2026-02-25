package org.dreamdevzone.exception;

public class ResourcesNotFoundException extends RuntimeException{
    public ResourcesNotFoundException(String message){
        super(message);
    }
}
