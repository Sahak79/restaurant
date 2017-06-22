package web.controller.manager;

import common.data.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Controller
@PreAuthorize("hasRole('ROLE_MANAGER')")
public class ManagerController {
    @RequestMapping("/manager/home")
    public String homeManager(@AuthenticationPrincipal User user) {
        return "manager/home";
    }
}
