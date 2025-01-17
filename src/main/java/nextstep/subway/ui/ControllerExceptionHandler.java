package nextstep.subway.ui;

import nextstep.member.ui.InvalidTokenException;
import nextstep.member.ui.NotExistsTokenException;
import nextstep.subway.domain.exceptions.CanNotDeleteFavoriteException;
import nextstep.subway.applicaion.exceptions.NotFoundFavoriteException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Void> handleIllegalArgsException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> handleIllegalArgsException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({InvalidTokenException.class, NotExistsTokenException.class})
    public ResponseEntity<Void> handleUnauthorizedException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(NotFoundFavoriteException.class)
    public ResponseEntity<Void> handleNotFoundException(NotFoundFavoriteException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(CanNotDeleteFavoriteException.class)
    public ResponseEntity<Void> handleForbiddenException(CanNotDeleteFavoriteException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
