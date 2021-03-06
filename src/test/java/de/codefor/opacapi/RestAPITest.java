package de.codefor.opacapi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestAPITest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getLibraries() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/libraries",
                String.class)).contains("Prien");
    }

    @Test
    public void getSearchFieldFromLibrary() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/libraries/Erlangen/searchFields",
                String.class)).contains("{\"id\":\"Free\",\"displayName\":\"Stichwort\",\"advanced\":false,\"visible\":true}");
    }


}