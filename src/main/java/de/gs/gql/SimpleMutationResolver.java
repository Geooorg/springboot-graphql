package de.gs.gql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.gs.dto.AddSimpleUserInput;
import de.gs.dto.SimpleUser;
import de.gs.SimpleUserRepo;
import org.springframework.stereotype.Component;

@Component
public class SimpleMutationResolver implements GraphQLMutationResolver {

    private final SimpleUserRepo userRepo;

    public SimpleMutationResolver(SimpleUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    SimpleUser addUser(AddSimpleUserInput input) {
        return userRepo.addSimpleUser(input);
    }


}
