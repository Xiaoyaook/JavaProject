package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * created by ziliang on 18-5-12
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler
    private Map<String, Object> exceptionHandler(Exception e){
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", false);
        modelMap.put("errMsg", e.getMessage());

        return modelMap;
    }
}
