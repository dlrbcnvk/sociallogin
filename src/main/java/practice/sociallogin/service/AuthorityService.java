package practice.sociallogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.sociallogin.model.Authority;
import practice.sociallogin.repository.AuthorityRepository;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Transactional
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }
}
