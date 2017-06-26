import com.oil.upms.dao.model.AdminExample;
import com.oil.upms.rpc.api.AdminService;
import com.oil.upms.rpc.api.UpmsApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 单元测试
 * Created by shuzheng on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:applicationContext.xml",
        "classpath:test/applicationContext-dubbo-consumer.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpmsServiceTest {

    @Autowired
    UpmsApiService upmsApiService;

    @Autowired
    AdminService adminService;

    @Test
    public void index() {
        AdminExample admin= new AdminExample();
        admin.createCriteria().andUseridEqualTo(1);
        adminService.deleteBy();
        System.out.println(adminService.countUpsByExample(admin));

    }

}
