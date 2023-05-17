package practice.sociallogin.converters;

import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.social.GoogleUser;
import practice.sociallogin.model.social.NaverUser;
import practice.sociallogin.util.OAuth2Utils;

public class OAuth2NaverProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser converter(ProviderUserRequest providerUserRequest) {
        if (!providerUserRequest.clientRegistration().getRegistrationId().equals("naver")) {
            return null;
        }
        return new NaverUser(OAuth2Utils.getSubAttributes(providerUserRequest.oAuth2User(), "response"),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
