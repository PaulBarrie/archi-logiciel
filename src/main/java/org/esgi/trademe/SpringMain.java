package org.esgi.trademe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class  SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        //--1. Create User
//        CreateMemberCommandHandler memberCommandHandler = applicationContext.getBean(CreateMemberCommandHandler.class);
//        CreatePaymentCommandHandler paymentCommandHandler = applicationContext.getBean(CreatePaymentCommandHandler.class);
//        CreateMember createUser = CreateMember.of("BOISSINOT", "GREGORY", "email",  AddressDTO.of("1","av de la République", "75012", "PARIS", "FRANCE"));
//        final MemberID userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
//        ModifyMemberAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyMemberAddressCommandHandler.class);
//        modifyUserAddressCommandHandler.handle(ModifyMemberAddress.of(userId.getValue(), AddressDTO.of("1","av de la République", "94562", "ALFORTVILLE", "FRANCE")));

        //--3. Retrieve all users
//        RetrieveMembers retrieveUsers = new RetrieveMembers();
//        RetrieveMembersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveMembersHandler.class);
//        final List<MemberDTO> users = retrieveUsersHandler.handle(retrieveUsers);
//        users.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city
//        RetrieveMembersByCity retrieveUsersByCity = new RetrieveMembersByCity("ALFORTVILLE");
//        RetrieveMembersByCityHandler retrieveUsersByCityHandler = applicationContext.getBean(RetrieveMembersByCityHandler.class);
//        final List<MemberDTO> searchedUsers = retrieveUsersByCityHandler.handle(retrieveUsersByCity);
//        searchedUsers.forEach(System.out::println);
    }
}
