package com.example.swagger_example.controller;

import com.example.swagger_example.entity.Greeting;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * created by ziliang on 18-7-5
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // 详细注解文档https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X#apioperation
    @ApiOperation(value = "打招呼")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") @ApiParam(value = "名称") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
