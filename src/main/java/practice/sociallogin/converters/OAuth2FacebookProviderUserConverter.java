package practice.sociallogin.converters;

import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.social.FacebookUser;
import practice.sociallogin.model.social.GithubUser;
import practice.sociallogin.util.OAuth2Utils;

public class OAuth2FacebookProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser converter(ProviderUserRequest providerUserRequest) {
        if (!providerUserRequest.clientRegistration().getRegistrationId().equals("facebook")) {
            return null;
        }
        return new FacebookUser(OAuth2Utils.getMainAttributes(providerUserRequest.oAuth2User()),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
