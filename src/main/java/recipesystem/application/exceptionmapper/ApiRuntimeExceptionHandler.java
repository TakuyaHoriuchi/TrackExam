package recipesystem.application.exceptionmapper;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 意図しないRuntimeExceptionが発生した時、指定のメッセージを返すHandlerクラス.
 */
@RestControllerAdvice
public class ApiRuntimeExceptionHandler {

  /**
   * RuntimeExceptionをHandlingするクラス.
   * 
   * @param e 意図せず発生したRuntimeException.
   * @return
   */
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Map<String, String> handleException(RuntimeException e) {
    return Collections.singletonMap("message",
                                    "意図しないRuntimeExceptionが発生しました. 例外:" + e.getMessage());
  }
}
