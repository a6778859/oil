import com.oil.upms.dao.model.Admin;
import com.oil.upms.rpc.api.AdminService;
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
        "classpath:META-INF/spring/applicationContext-jdbc.xml",
        "classpath:META-INF/spring/applicationContext-listener.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UpmsServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    public void index() {
        Admin test = adminService.test(1);
        System.out.println(test+"master");
        test = adminService.insert2(1);
        System.out.println(test+"master");
    }

//    @Test
//    public void selectForPage() {
//        // 根据条件，按页码+每页条数分页
//        UpmsPermissionExample upmsPermissionExample = new UpmsPermissionExample();
//        upmsPermissionExample.createCriteria()
//                .andSystemIdEqualTo(1);
//        List<UpmsPermission> upmsPermissions = upmsPermissionService.selectByExampleForStartPage(upmsPermissionExample, 2, 20);
//        System.out.println(upmsPermissions.size());
//        // 根据条件，按offset+limit分页
//        upmsPermissionExample = new UpmsPermissionExample();
//        upmsPermissionExample.createCriteria()
//                .andSystemIdEqualTo(2);
//        upmsPermissions = upmsPermissionService.selectByExampleForOffsetPage(upmsPermissionExample, 3, 5);
//        System.out.println(upmsPermissions.size());
//    }

}
