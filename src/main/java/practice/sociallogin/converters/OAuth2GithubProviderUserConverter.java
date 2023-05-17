package practice.sociallogin.converters;

import practice.sociallogin.model.ProviderUser;
import practice.sociallogin.model.social.GithubUser;
import practice.sociallogin.model.social.NaverUser;
import practice.sociallogin.util.OAuth2Utils;

public class OAuth2GithubProviderUserConverter implements ProviderUserConverter<ProviderUserRequest, ProviderUser> {
    @Override
    public ProviderUser converter(ProviderUserRequest providerUserRequest) {
        if (!providerUserRequest.clientRegistration().getRegistrationId().equals("github")) {
            return null;
        }
        return new GithubUser(OAuth2Utils.getMainAttributes(providerUserRequest.oAuth2User()),
                providerUserRequest.oAuth2User(),
                providerUserRequest.clientRegistration());
    }
}
