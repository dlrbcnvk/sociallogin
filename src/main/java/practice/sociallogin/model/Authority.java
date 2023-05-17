package practice.sociallogin.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Authority {

    @Id
    @Column(name = "AUTHORITY_ID")
    private String id;
    private String authority;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
