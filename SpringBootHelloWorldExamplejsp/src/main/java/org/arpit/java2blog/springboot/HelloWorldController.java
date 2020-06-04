
package org.arpit.java2blog.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {
 
 @RequestMapping("/helloworld")
 public ModelAndView hello() {
 
  String helloWorldMessage = "Hello world Springboot JSP!";
  return new ModelAndView("hello", "message", helloWorldMessage);
 }
}
