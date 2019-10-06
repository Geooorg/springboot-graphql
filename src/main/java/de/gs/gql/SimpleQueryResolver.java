package de.gs.gql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.gs.dto.SimpleUser;
import de.gs.SimpleUserRepo;
import org.springframework.stereotype.Component;

@Component
public class SimpleQueryResolver implements GraphQLQueryResolver {

    private final SimpleUserRepo userRepo;

    public SimpleQueryResolver(SimpleUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    SimpleUser findUserById(String id) {
        return userRepo.getSimpleUserById(id);
    }

}
