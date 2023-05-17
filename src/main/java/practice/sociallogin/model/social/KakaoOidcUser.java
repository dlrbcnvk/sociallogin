package practice.sociallogin.model.social;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.user.OAuth2User;
import practice.sociallogin.model.Attributes;
import practice.sociallogin.model.OAuth2ProviderUser;

import java.util.Map;

public class KakaoOidcUser extends OAuth2ProviderUser {

    private Map<String, Object> subAttributes;
    private Map<String, Object> thirdAttributes;

    public KakaoOidcUser(Attributes attributes, OAuth2User oAuth2User, ClientRegistration clientRegistration) {
        super(attributes.getMainAttributes(), oAuth2User, clientRegistration);
    }

    @Override
    public String getId() {
        return (String) getAttributes().get("sub");
    }

    @Override
    public String getUsername() {
        return (String) getAttributes().get("nickname");
    }

    @Override
    public String getPicture() {
        return (String) getAttributes().get("picture");
    }

    @Override
    public String getEmail() {
        return (String) getAttributes().get("email");
    }
}
