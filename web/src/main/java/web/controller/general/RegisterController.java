package web.controller.general;

import common.data.model.User;
import common.data.model.lcp.UserProfile;
import data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Controller
public class RegisterController {
    private UserService userService;

    private MessageSource messageSource;

    @Autowired
    public RegisterController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(User user) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("confirmPassword") String confirmPassword,
                           @Valid User user,
                           BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        // validating password
        if (StringUtils.isEmpty(user.getPassword())) {
            String message = messageSource.getMessage("err.field.password.required", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "register";
        } else if (!user.getPassword().equals(confirmPassword)) {
            // validating confirm password
            String message = messageSource.getMessage("err.field.mismatched.confirm.password", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "password", message));
            return "register";
        }

        // checking whether the email address is already used
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (isEmailExist) {
            String message = messageSource.getMessage("err.field.email.exist", null, LocaleContextHolder.getLocale());
            result.addError(new FieldError("user", "email", message));
            return "register";
        }

        user.setProfile(UserProfile.MANAGER);

        // storing user's data
        userService.add(user);

        // going to login page
        return "redirect:login";
    }
}
