package practice.sociallogin.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {

    @Id
    @Column(name = "USER_ID")
    private String id;

    private String registrationId;
    private String username;
    private String password;
    private String provider;
    private String email;

    @OneToMany(mappedBy = "authority")
    private List<Authority> authority = new ArrayList<>();

    public User() {

    }

    /**
     * List<? extends GrantedAuthority> -> List<Authority>
     */
    public List<Authority> switchToAuthorityEntityClass(List<? extends GrantedAuthority> grantedAuthorities) {
        ArrayList<Authority> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : grantedAuthorities) {
            Authority authority = new Authority();
            authority.setId(UUID.randomUUID().toString());
            authority.setAuthority(grantedAuthority.getAuthority());
            authority.setUser(this);
            authorities.add(authority);
        }
        return authorities;
    }

    public User(String registrationId, ProviderUser providerUser) {

        this.id = providerUser.getId();
        this.registrationId = registrationId;
        this.username = providerUser.getUsername();
        this.password = providerUser.getPassword();
        this.provider = providerUser.getProvider();
        this.email = providerUser.getEmail();
    }

}
