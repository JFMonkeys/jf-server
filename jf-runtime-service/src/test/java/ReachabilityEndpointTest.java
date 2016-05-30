import com.github.jfmonkeys.services.common.ServiceModule;
import com.github.jfmonkeys.services.runtime.RuntimeModule;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by monkey on 31/05/16.
 */
@RunWith(VertxUnitRunner.class)
public class ReachabilityEndpointTest extends ServiceTestBase{

    @Override
    public ServiceModule getModuleUnderTest() {
        return new RuntimeModule();
    }

    @Test
    public void testMyApplication(TestContext context) {
        final Async async = context.async();

        vertx.createHttpClient().getNow(port, host, "/reach",
                response -> {
                    response.handler(body -> {
                        context.assertEquals("elllo222!!!",body.toString());
                        async.complete();
                    });
                });
    }


}
