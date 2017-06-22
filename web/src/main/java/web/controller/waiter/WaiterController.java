package web.controller.waiter;

import common.data.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Controller
@PreAuthorize("hasRole('ROLE_WAITER')")
public class WaiterController {
    @RequestMapping("/waiter/home")
    public String homeWaiter(@AuthenticationPrincipal User user) {
        return "waiter/home";
    }

    @RequestMapping("/waiter/tables")
    public String tables(@AuthenticationPrincipal User user) {
        return "waiter/tables";
    }

}
