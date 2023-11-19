package pe.edu.upc.aww.werecycle.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pe.edu.upc.aww.werecycle.entities.Roles;
import pe.edu.upc.aww.werecycle.entities.Useror;
import pe.edu.upc.aww.werecycle.repositories.ITypeUserRepository;
import pe.edu.upc.aww.werecycle.repositories.IUserRepository;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    private final IUserRepository userRepository;
    private final ITypeUserRepository typeUserRepository;

    public Runner(IUserRepository userRepository, ITypeUserRepository typeUserRepository) {
        this.userRepository = userRepository;
        this.typeUserRepository = typeUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Useror useror = new Useror();
        useror.setUserName("ADMIN");
        useror.setUserPassword("$2a$12$kfo6Az5ZfFRSoY9WMJAASeXycMsPVPhLlzCsJ4TwU3WDPUlio694C");
        useror.setUserEmail("admin@gmail.com");
        useror.setUserAge(LocalDate.ofEpochDay(20020905));
        useror.setEnabled(true);
        userRepository.save(useror);

        Roles roles = new Roles();
        roles.setStateType(true);
        roles.setTypeAccount("ADMIN");
        roles.setUseror(useror);
        typeUserRepository.save(roles);

        Useror useror2 = new Useror();
        useror2.setUserName("WEB");
        useror2.setUserPassword("$2a$12$kfo6Az5ZfFRSoY9WMJAASeXycMsPVPhLlzCsJ4TwU3WDPUlio694C");
        useror2.setUserEmail("WEB@gmail.com");
        useror2.setUserAge(LocalDate.ofEpochDay(20020904));
        useror2.setEnabled(true);
        userRepository.save(useror2);

        Roles roles2 = new Roles();
        roles2.setStateType(true);
        roles2.setTypeAccount("WEB");
        roles2.setUseror(useror2);
        typeUserRepository.save(roles2);

        Useror useror3 = new Useror();
        useror3.setUserName("centro");
        useror3.setUserPassword("$2a$12$kfo6Az5ZfFRSoY9WMJAASeXycMsPVPhLlzCsJ4TwU3WDPUlio694C");
        useror3.setUserEmail("centro@gmail.com");
        useror3.setUserAge(LocalDate.ofEpochDay(20020903));
        useror3.setEnabled(true);
        userRepository.save(useror3);

        Roles roles3 = new Roles();
        roles3.setStateType(true);
        roles3.setTypeAccount("centro");
        roles3.setUseror(useror3);
        typeUserRepository.save(roles3);
    }
}
