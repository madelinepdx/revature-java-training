package Lab.Controller;

import Lab.Model.Sample;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * You're most likely going to need to have greater control over the exact details of your HTTP responses than
 * was previously offered by the RestController. For instance, you may want to respond with a 400 bad request,
 * 401 unauthorized, or 201 resource created rather than a 200 OK message. ResponseEntities will also allow you to
 * set the HTTP headers of your response, such as setting the content type between JSON, XML, ZIP, etc.
 */
@RestController
public class Controller {

    /**
     * Here's an example of how a response can be sent with a custom status code, as well as an informational message
     * in the response body as a String.
     */
    @GetMapping("/example401")
    public ResponseEntity example(){
        return ResponseEntity.status(401).body("Unauthorized resource!");
    }
    /**
     * ResponseEntity will also be useful for sending specific headers in the response. Here is a demonstration
     * of setting the status code to 200, the body to the "sample" class, and a content type to a compressed zip
     * file - a niche situation, but one found in the real world regardless.
     */
    @GetMapping("/exampleHeaders")
    public ResponseEntity headers(@RequestBody Sample sample){
        return ResponseEntity.status(200).header("content-type", "application/zip").body(sample);
    }
    /**
     * TODO: return a ResponseEntity containing a response of type "Bad Request", as well as a String in the body
     * that says "Bad Request"
     */
    @GetMapping("/lab1")
    public ResponseEntity lab1(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
    }
    /**
     * TODO: return a ResponseEntity containing a response of type "Resource Created", setting the "content-length"
     * header to a value of "100", and responding with a body containing the Sample object received in the request
     * body.
     */
    @GetMapping("/lab2")
    public ResponseEntity lab2(@RequestBody Sample sample){
        return ResponseEntity.status(HttpStatus.CREATED).header("content-length", "100").body(sample);
    }
}
