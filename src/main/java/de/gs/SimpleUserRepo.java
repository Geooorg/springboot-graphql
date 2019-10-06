package de.gs;

import de.gs.dto.AddSimpleUserInput;
import de.gs.dto.SimpleUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleUserRepo {

    private Map<String, SimpleUser> repo = new HashMap<>();

    public SimpleUser addSimpleUser(AddSimpleUserInput input) {
        SimpleUser user = new SimpleUser(input.getName(), input.getAddress());
        repo.put(user.getId(), user);
        return user;
    }

    public SimpleUser getSimpleUserById(String id) {
        return repo.get(id);
    }

}
