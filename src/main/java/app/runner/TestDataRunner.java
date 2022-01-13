package app.runner;

import app.domain.Admin;
import app.domain.Client;
import app.domain.Rank;
import app.domain.User;
import app.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    AdminRepository adminRepository;
    ClientRepository clientRepository;
    ManagerRepository managerRepository;
    RankRepository rankRepository;
    UserRepository userRepository;

    public TestDataRunner(AdminRepository adminRepository, ClientRepository clientRepository, ManagerRepository managerRepository, RankRepository rankRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
        this.managerRepository = managerRepository;
        this.rankRepository = rankRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert roles
//        Role roleUser = new Role("ROLE_USER", "User role");
//        Role roleAdmin = new Role("ROLE_ADMIN", "Admin role");
//        roleRepository.save(roleUser);
//        roleRepository.save(roleAdmin);
        //Insert rank
        Rank rankGold = new Rank("GOLD", 20,50, 30);
        Rank rankSilver = new Rank("SILVER", 10,20, 20);
        Rank rankBronze = new Rank("BRONZE", 0,10, 10);

        rankRepository.save(rankGold);
        rankRepository.save(rankSilver);
        rankRepository.save(rankBronze);

        //Insert User
        User userAdmin = new User("admin@gmail.com", "Admin", "Adminic", "admin", "admin",
                1234567890L, new SimpleDateFormat("dd/MM/yyyy").parse("03/08/2000"), rankGold, "ROLE_ADMIN");
//        User userClient = new User("client@gmail.com", "Client", "Clientic", "client", "client",
//                178945624L, new SimpleDateFormat("dd/MM/yyyy").parse("12/08/2000"), rankGold, "ROLE_CLIENT");
        userRepository.save(userAdmin);
//        userRepository.save(userClient);
        //Insert admin
        Admin admin = new Admin();
        admin.setUser(userAdmin);
        adminRepository.save(admin);
//        Client client = new Client()

    }
}
