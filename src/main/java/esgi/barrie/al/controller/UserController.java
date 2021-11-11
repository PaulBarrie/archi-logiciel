package esgi.barrie.cc1.controller;

import esgi.barrie.cc1.infrastructure.service.user.UserDatabaseService;
import esgi.barrie.cc1.model.user.User;
import com.barrie.cc1.infrastructure.user.UserInfrastructureService;

public final class UserController {
    private User user;
    private UserDatabaseService infrastructureService;

    private UserController(User user, UserDatabaseService infrastructureService) {
        this.user = user;
        this.infrastructureService = infrastructureService;
    }

    public static UserController of(User user, UserDatabaseService infrastructureService) {
        return new UserController(user, infrastructureService);
    }

    public void registerUser(User user) {
        this.infrastructureService.insert(user);
    }

}
