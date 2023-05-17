package practice.sociallogin.converters;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.social.KakaoOidcUser;
import practice.sociallogin.util.OAuth2Utils;

public class OAuth2KakaoOidcProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser converter(ProviderUserRequest providerUserRequest) {
        if (!providerUserRequest.clientRegistration().getRegistrationId().equals("kakao")) {
            return null;
        }

        return new KakaoOidcUser(OAuth2Utils.getMainAttributes(providerUserRequest.oAuth2User()),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
