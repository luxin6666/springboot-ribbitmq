import com.luxin.springbootribbitmq.SpringbootRibbitmqApplication;
import com.luxin.springbootribbitmq.exchange.fanout.Provider_User1_Fanout;
import com.luxin.springbootribbitmq.exchange.fanout.Provider_User2_Fanout;
import com.luxin.springbootribbitmq.exchange.topic.Provider_User1_Topic;
import com.luxin.springbootribbitmq.exchange.topic.Provider_User2_Topic;
import com.luxin.springbootribbitmq.exchange.topic.Provider_User3_Topic;
import com.luxin.springbootribbitmq.service.Provider;
import com.luxin.springbootribbitmq.exchange.direct.Provider_direct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRibbitmqApplication.class)
public class myTest {

    @Autowired
    private Provider provider;
    @Autowired
    private Provider_direct provider_direct;
    @Autowired
    private Provider_User1_Topic provider_user1_topic;
    @Autowired
    private Provider_User2_Topic provider_user2_topic;
    @Autowired
    private Provider_User3_Topic provider_user3_topic;
    @Autowired
    private Provider_User1_Fanout provider_user1_fanout;
    @Autowired
    private Provider_User2_Fanout provider_user2_fanout;

    @Test
    public void test(){
        provider.send("RibbitMQ，你太丑了！");
    }
    @Test
    public void test2(){
        provider_direct.send("RibbitMQ，你太帅了！");
    }
    @Test
    public void test3(){
        provider_user1_topic.send("RibbitMQ，你真的超级帅！provider_user1_topic");
        provider_user2_topic.send("RibbitMQ，你真的超级帅！provider_user2_topic");
        provider_user3_topic.send("RibbitMQ，你真的超级帅！provider_user3_topic");
    }

    @Test
    public void test4(){
        provider_user1_fanout.send("RibbitMQ，你真的超好用！provider_user1_fanout");
        //provider_user2_fanout.send("RibbitMQ，你真的超好用！provider_user2_fanout");
    }
}
