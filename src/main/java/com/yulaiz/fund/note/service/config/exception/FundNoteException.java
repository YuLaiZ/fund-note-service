package com.yulaiz.fund.note.service.config.exception;

public class FundNoteException extends RuntimeException {
    public FundNoteException() {
        super();
    }

    public FundNoteException(String message) {
        super(message);
    }

    public FundNoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public FundNoteException(Throwable cause) {
        super(cause);
    }
}
