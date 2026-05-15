package sn.edu.isepat.tic.dbe.p6.GestionScolaire.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    APPRENANTE_NOT_FOUND(1001),
    APPRENANTE_ALREADY_EXISTS(1002),
    APPRENANTE_INVALID_DATA(1003),

    INSCRIPTION_NOT_FOUND(2001),
    INSCRIPTION_INVALID_AMOUNT(2002),
    INSCRIPTION_DATE_MISSING(2003);

    private final Integer code;
    ErrorCode(Integer code) {
        this.code = code;
    }
}