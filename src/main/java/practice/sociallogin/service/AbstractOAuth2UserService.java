package practice.sociallogin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;
import practice.sociallogin.converters.ProviderUserConverter;
import practice.sociallogin.converters.ProviderUserRequest;
import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.User;
import practice.sociallogin.repository.UserRepository;

@Service
@Slf4j
public abstract class AbstractOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProviderUserConverter<ProviderUserRequest, ProviderUser> providerUserConverter;

    protected void register(ProviderUser providerUser, OAuth2UserRequest userRequest) {
        User user = userRepository.findById(providerUser.getId());
        if (user == null) {
            userService.register(userRequest.getClientRegistration().getRegistrationId(), providerUser);
        } else {
            // DB에 이미 등록된 회원
            log.info("user={}", user);
        }
    }

    public ProviderUser providerUser(ProviderUserRequest providerUserRequest) {
        return providerUserConverter.converter(providerUserRequest);
    }
}
