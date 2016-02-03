package demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class UserController {

    @RequestMapping("/message")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> dashboard() {
        return Collections.<String, Object>singletonMap("message", "Yay!");
    }

    @RequestMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public Principal user(Principal user) {
        return user;
    }

}
