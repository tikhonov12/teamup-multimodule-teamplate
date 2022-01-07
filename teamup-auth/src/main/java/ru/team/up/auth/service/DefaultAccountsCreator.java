package ru.team.up.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import ru.team.up.core.entity.Admin;
import ru.team.up.core.entity.Moderator;
import ru.team.up.core.entity.Role;
import ru.team.up.core.entity.User;
import ru.team.up.core.repositories.AdminRepository;
import ru.team.up.core.repositories.ModeratorRepository;
import ru.team.up.core.repositories.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DefaultAccountsCreator {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ModeratorRepository moderatorRepository;

    @Autowired
    public DefaultAccountsCreator(UserRepository userRepository,  AdminRepository adminRepository, ModeratorRepository moderatorRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.moderatorRepository = moderatorRepository;
    }

    @Bean
    public void userCreator() {
        userRepository.save(User.builder()
                .id(1L)
                .name("Andrey")
                .lastName("Tikhonov")
                .middleName("Vladimirovich")
                .login("atata256")
                .password(BCrypt.hashpw("1234", BCrypt.gensalt(10)))
                .accountCreatedTime(LocalDate.now())
                .lastAccountActivity(LocalDateTime.now())
                .email("user@mail.ru")
                .age(12)
                .role(Role.ROLE_USER)
                .build());

        adminRepository.save(Admin.builder()
                .id(2L)
                .name("admins")
                .lastName("admins")
                .middleName("admins")
                .login("admins")
                .password(BCrypt.hashpw("admins", BCrypt.gensalt(10)))
                .accountCreatedTime(LocalDate.now())
                .lastAccountActivity(LocalDateTime.now())
                .email("admins@mail.ru").role(Role.ROLE_ADMIN)
                .build());


        moderatorRepository.save(Moderator.builder()
                .id(3L)
                .name("moderators")
                .lastName("moderators")
                .middleName("moderatos")
                .login("moderators")
                .password(BCrypt.hashpw("moderator", BCrypt.gensalt(10)))
                .accountCreatedTime(LocalDate.now())
                .lastAccountActivity(LocalDateTime.now())
                .email("moderators@mail.ru")
                .role(Role.ROLE_MODERATOR)
                .amountOfCheckedEvents(2L)
                .amountOfClosedRequests(2L)
                .amountOfDeletedEvents(3L)
                .build());
    }
}
