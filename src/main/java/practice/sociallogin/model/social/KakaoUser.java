package practice.sociallogin.model.social;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.user.OAuth2User;
import practice.sociallogin.model.Attributes;
import practice.sociallogin.model.OAuth2ProviderUser;

import java.util.Map;

public class KakaoUser extends OAuth2ProviderUser {

    private Map<String, Object> subAttributes;
    private Map<String, Object> thirdAttributes;

    public KakaoUser(Attributes attributes, OAuth2User oAuth2User, ClientRegistration clientRegistration) {
        super(attributes.getMainAttributes(), oAuth2User, clientRegistration);
        this.subAttributes = attributes.getSubAttributes();
        this.thirdAttributes = attributes.getThirdAttributes();
    }

    @Override
    public String getId() {
        Long LongId = (Long) getAttributes().get("id");
        return LongId.toString();
    }

    @Override
    public String getUsername() {
        return (String) thirdAttributes.get("nickname");
    }

    @Override
    public String getPicture() {
        return (String) thirdAttributes.get("profile_image_url");
    }

    @Override
    public String getEmail() {
        return (String) subAttributes.get("email");
    }
}
