import me.yu.dao.RoleMapper;
import me.yu.dao.TransferMapper;
import me.yu.dao.UserMapper;
import me.yu.domain.Role;
import me.yu.domain.Transfer;
import me.yu.domain.User;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class springTest {
    @Autowired
    TransferMapper transferMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserMapper userMapper;
    @Test
    public void t1(){
        Transfer transfer = transferMapper.findByUid(1);
        System.out.println(transfer);
    }
    @Test
    public void t2(){
        User userAllByUid = userMapper.findUserAllByUid(1);
        System.out.println(userAllByUid);
    }
    @Test
    public void t3(){
        Role role = roleMapper.findByRid(1);
        System.out.println(role);
    }
    @Test
    public void addUser(){
        User user = new User();
        user.setId(6);
        user.setUsername("杰克马");
        user.setPassword("123456");
        user.setSave(9999.99);
        userMapper.insertUser(user);
    }
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(6);
        user.setUsername("pony马");
        user.setPassword("123123");
        user.setSave(99.9);
        user.setProfile("不充钱你是不会变强的！");
        userMapper.updateUser(user);
    }
    @Test
    public void deleteUser(){
        userMapper.deleteUser(6);
    }
    @Test
    public void updateUserSave(){
        userMapper.updateSave(6,-1.0);
    }
    @Test
    public void transferMonay(){
        Integer f_uid=5;
        Integer t_uid=6;
        double money=100;
        Transfer transfer = new Transfer();
        transfer.setF_uid(f_uid);
        transfer.setT_uid(t_uid);
        transfer.setMoney(money);
        userMapper.updateSave(f_uid,-money);
        userMapper.updateSave(t_uid,money);
        transferMapper.insetTransfer(transfer);
    }
}
