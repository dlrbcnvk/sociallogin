package practice.sociallogin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.sociallogin.model.PrincipalUser;

@RestController
@Slf4j
public class HomeController {

    @GetMapping("/api/user")
    public String user(Authentication authentication, @AuthenticationPrincipal PrincipalUser principalUser) {
        logUserInfo(authentication, principalUser);
        return "user";
    }

    @GetMapping("/api/oidc")
    public String oidc(Authentication authentication, @AuthenticationPrincipal PrincipalUser principalUser) {
        logUserInfo(authentication, principalUser);
        return "oidc";
    }

    public void logUserInfo(Authentication authentication, @AuthenticationPrincipal PrincipalUser principalUser) {
        log.info("authentication={}", authentication);
        log.info("principalUser={}", principalUser);
        log.info("provider={}", principalUser.providerUser().getProvider());
        log.info("id={}", principalUser.providerUser().getId());
        log.info("email={}", principalUser.providerUser().getEmail());
        log.info("username={}", principalUser.providerUser().getUsername());
    }
}
