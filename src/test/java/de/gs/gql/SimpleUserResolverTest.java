package de.gs.gql;

import de.gs.dto.AddSimpleUserInput;
import de.gs.dto.SimpleUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleUserResolverTest {

    @Autowired
    SimpleQueryResolver queryResolver;
    @Autowired
    SimpleMutationResolver mutationResolver;

    @Test
    public void canAddAndRetrieveUser() {
        // given
        String name = "Test User";
        String address = "Testing street";
        // when
        SimpleUser addedUser = mutationResolver.addUser(new AddSimpleUserInput(name, address));

        assertNotNull(addedUser.getId());
        assertEquals(name, addedUser.getName());
        assertEquals(address, addedUser.getAddress());

        SimpleUser foundUser = queryResolver.findUserById(addedUser.getId());
        assertNotNull(foundUser.getId());
        assertEquals(foundUser, addedUser);
    }
}
