package org.dvdrental.sharedkernel.validation;

import org.dvdrental.sharedkernel.exception.EmptyArgumentException;

public class Check {
    public static void notNull(Object obj, String msg) throws EmptyArgumentException {
        if (obj == null) throw new EmptyArgumentException(msg);
    }
}
