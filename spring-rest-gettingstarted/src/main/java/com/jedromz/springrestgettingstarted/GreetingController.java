package com.jedromz.springrestgettingstarted;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 *  @RestController annotation, which marks the class as a controller
 *  where every method returns a domain object
 *  instead of a view. It is shorthand for including both @Controller and @ResponseBody.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *
     * @param name @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method.
     * @return The object data will be written directly to the HTTP response as JSON.
     */
    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
