package web.controller.general;

import common.data.model.User;
import common.data.model.lcp.UserProfile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_WAITER')")
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        if (user.getProfile() == UserProfile.MANAGER) {
            return "redirect:manager/home";
        }
        return "redirect:waiter/home";
    }
}
