package practice.sociallogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.sociallogin.model.Authority;
import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.User;
import practice.sociallogin.repository.AuthorityRepository;
import practice.sociallogin.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final AuthorityService authorityService;

    @Transactional
    public void register(String registrationId, ProviderUser providerUser) {

        User user = new User(registrationId, providerUser);

        List<Authority> authorities = user.switchToAuthorityEntityClass(providerUser.getAuthorities());
        user.setAuthority(authorities);

        for (Authority authority : authorities) {
            authorityService.save(authority);
        }
        userRepository.register(user);
    }


}
