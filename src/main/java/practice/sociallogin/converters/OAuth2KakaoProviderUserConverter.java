package practice.sociallogin.converters;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.social.KakaoUser;
import practice.sociallogin.model.social.NaverUser;
import practice.sociallogin.util.OAuth2Utils;

public class OAuth2KakaoProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser converter(ProviderUserRequest providerUserRequest) {
        if (!providerUserRequest.clientRegistration().getRegistrationId().equals("kakao")) {
            return null;
        }
        if (providerUserRequest.oAuth2User() instanceof OidcUser) {
            return null;
        }
        return new KakaoUser(OAuth2Utils.getThirdAttributes(providerUserRequest.oAuth2User(), "kakao_account", "profile"),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
