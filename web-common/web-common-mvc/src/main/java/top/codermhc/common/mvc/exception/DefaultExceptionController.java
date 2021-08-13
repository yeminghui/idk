package top.codermhc.common.mvc.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.codermhc.common.result.DefaultResultStatus;
import top.codermhc.common.result.ResponseWrapper;

import java.util.stream.Collectors;


/**
 * @author yemh
 */
@RestControllerAdvice
public class DefaultExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseWrapper<String> invalidParameter(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        return ResponseWrapper.error(msg);
    }

    @ExceptionHandler(Exception.class)
    public ResponseWrapper<Exception> error(Exception e) {
        return ResponseWrapper.<Exception>builder().code(DefaultResultStatus.ERROR).data(e).build();
    }
}
