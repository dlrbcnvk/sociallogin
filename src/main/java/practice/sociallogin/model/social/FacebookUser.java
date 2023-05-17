package practice.sociallogin.model.social;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.user.OAuth2User;
import practice.sociallogin.model.Attributes;
import practice.sociallogin.model.OAuth2ProviderUser;

public class FacebookUser extends OAuth2ProviderUser {

    public FacebookUser(Attributes mainAttributes, OAuth2User oAuth2User, ClientRegistration clientRegistration) {
        super(mainAttributes.getMainAttributes(), oAuth2User, clientRegistration);
    }

    @Override
    public String getId() {
        return ((String) getAttributes().get("id"));
    }

    @Override
    public String getUsername() {
        return (String) getAttributes().get("name");
    }

    @Override
    public String getPicture() {
        return (String) getAttributes().get("avatar_url");
    }
}
