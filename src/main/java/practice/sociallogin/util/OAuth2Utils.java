package practice.sociallogin.util;

import org.springframework.security.oauth2.core.user.OAuth2User;
import practice.sociallogin.model.Attributes;

import java.util.Map;

public class OAuth2Utils {

    public static Attributes getMainAttributes(OAuth2User oAuth2User) {
        return Attributes.builder()
                .mainAttributes(oAuth2User.getAttributes())
                .build();
    }

    public static Attributes getSubAttributes(OAuth2User oAuth2User, String subAttributesKey) {
        Map<String, Object> subAttributes = (Map<String, Object>) oAuth2User.getAttributes().get(subAttributesKey);
        return Attributes.builder()
                .subAttributes(subAttributes)
                .build();
    }

    public static Attributes getThirdAttributes(OAuth2User oAuth2User, String subAttributesKey, String thirdAttributesKey) {
        Map<String, Object> subAttributes = (Map<String, Object>) oAuth2User.getAttributes().get(subAttributesKey);
        Map<String, Object> thirdAttributes = (Map<String, Object>) subAttributes.get(thirdAttributesKey);

        return Attributes.builder()
                .mainAttributes(oAuth2User.getAttributes())
                .subAttributes(subAttributes)
                .thirdAttributes(thirdAttributes)
                .build();
    }
}
