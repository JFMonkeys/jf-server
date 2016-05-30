import com.github.jfmonkeys.services.common.DeploymentContext;
import com.github.jfmonkeys.services.common.ServiceModule;
import com.github.jfmonkeys.services.common.ServiceModuleBootstrap;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * Created by monkey on 31/05/16.
 */

@RunWith(VertxUnitRunner.class)
public abstract class ServiceTestBase {

    protected Vertx vertx;
    protected int port;
    protected String host = "localhost";

    @Before
    public void setUp(TestContext context) {
        DeploymentContext ctx = ServiceModuleBootstrap.run(getModuleUnderTest(), context.asyncAssertSuccess());
        vertx = ctx.getVertx();
        port = ctx.getPort();
    }

    @After
    public void tearDown(TestContext context) {
        vertx.close(context.asyncAssertSuccess());
    }

    public abstract ServiceModule getModuleUnderTest();
}
