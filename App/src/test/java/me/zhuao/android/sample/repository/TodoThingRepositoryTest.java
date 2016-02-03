package me.zhuao.android.sample.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URI;
import java.util.List;

import me.zhuao.android.sample.BuildConfig;
import me.zhuao.android.sample.domain.TodoThing;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TodoThingRepositoryTest {

    //TODO:Study what's the TestRule mean
//    @Rule
    public final MockWebServer server = new MockWebServer();

    private static String response = "{\"results\": []}";

    @Before
    public void setUp() throws Exception {
        URI uri = URI.create(BuildConfig.HTTP_SERVER_HOST);
        server.start(InetAddress.getByName(uri.getHost()), uri.getPort() == -1 ? 0 : uri.getPort());
    }

    @Test
    public void should_retrieve_todo_thing_back() {
        server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(response));

        TodoThingRepository todoThingRepository = new TodoThingRepository();
        List<TodoThing> first = todoThingRepository.todoThings().toBlocking().first();
        assertThat(first.size()).isEqualTo(0);
    }

    @After
    public void tearDown() throws IOException {
        server.shutdown();
    }
}