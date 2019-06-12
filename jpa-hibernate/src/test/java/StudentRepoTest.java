import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import com.jpa.hibernate.demo.JpaDemoApplication;
import com.jpa.hibernate.demo.repo.StudentRepo;
import com.jpa.hibernate.demo.entity.Student;
import com.jpa.hibernate.demo.entity.passport;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class StudentRepoTest {
//private Logger logger = LoggerFactory.getLogger(this.getClass()); 

@Autowired
StudentRepo studentRepoTest;
//@Test
@DirtiesContext
public void retriveDetailsAndPassport() {
	Student student=studentRepoTest.findById(12);
	System.err.println("Student Test"+student.getPassport().getPassportNo());
	assertEquals("sudhir",student.getName());
	assertEquals("IND0021165", student.getPassport().getPassportNo());
	//assertEquals("18",student.getPassport().getId());
	
}
@Test
@Transactional
public void functionForTransactionalVerify() {
	Student student=studentRepoTest.findById(12);
	System.err.println("roll back");
	passport passport=student.getPassport();
	passport.setPassportNo("IND9211420");
	student.setName("Ranjeet");
	
	
	
}
}
