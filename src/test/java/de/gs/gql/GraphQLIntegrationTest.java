package de.gs.gql;

import com.github.kevinsawicki.http.HttpRequest;
import de.gs.SimpleUserRepo;
import de.gs.dto.AddSimpleUserInput;
import de.gs.dto.SimpleUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GraphQLIntegrationTest {

    @LocalServerPort
    private int port;

    private String host = "http://localhost";
    @Value("${graphql.servlet.mapping}")
    private String gqlPath;

    private String graphQLUrl;

    @Autowired
    private SimpleUserRepo userRepo;

    @Before
    public void beforeSetup() {
        graphQLUrl = host + ":" + port + gqlPath;
    }

    @Test
    public void applicationCanFindUserByGraphQLQuery() {
        // given
        String name = "Test User";
        String address = "Testing street";
        SimpleUser addedUser = userRepo.addSimpleUser(new AddSimpleUserInput(name, address));

        String query = "{\"query\":\"query {\\n  " +
                "findUserById(ID:\\\"" + addedUser.getId() + "\\\") " +
                "{\\n    name\\n  }\\n}\"" +
                ",\"variables\":null}";
        System.out.println(query);

        // when
        String responseJson = HttpRequest.post(graphQLUrl)
                .acceptJson()
                .contentType("application/json;charset=UTF-8")
                .send(query)
                .body();

        // then
        System.out.println(responseJson);
        assertThat(responseJson, hasJsonPath("$.data.findUserById.name", is("Test User")));
    }


}
