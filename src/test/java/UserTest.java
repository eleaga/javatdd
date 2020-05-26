import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import java.util.function.IntPredicate;

public class UserTest  {


    @Test
    public void userShouldNotIsOver() throws Exception {
        User user = new User();
        final String METHOD="getAge";

        User spy = PowerMockito.spy(user);
        PowerMockito.when(spy, METHOD).thenReturn((Integer) 0 );
        boolean isOver = spy.validateAge();

        Assert.assertEquals(isOver, false );
    }

    @Test
    public void userShouldIsOver() throws Exception {
        User user = new User();
        final String METHOD="getAge";
        User spy = PowerMockito.spy(user);
        PowerMockito.when(spy, METHOD).thenReturn((Integer) 20 );

        boolean isOver = spy.validateAge();

        Assert.assertEquals(isOver, true);
    }

    @Test
    public void userShouldIsEqualOverAge() throws Exception {
        User user = new User();
        final String METHOD="getAge";
        User spy = PowerMockito.spy(user);
        PowerMockito.when(spy, METHOD).thenReturn((Integer) 18 );

        boolean isOver = spy.validateAge();

        Assert.assertEquals(isOver, true);
    }

    @Test
    public void userShoulHaveFullName() throws Exception {
        User user = new User();

        user.firstName="Luiz";
        user.lastName="Bezerra";

        Assert.assertEquals(user.getFullName(), "Luiz Bezerra");
    }

    @Test
    public void userShoulHaveValidEmail() throws Exception {
        User user = new User();

        Boolean email = user.isEmailValid("asd@asd.com");

        Assert.assertEquals(email, true);
    }

    @Test
    public void userShoulHaveNotInvalidEmail() throws Exception {
        User user = new User();

        Boolean email = user.isEmailValid("asd@asd");

        Assert.assertEquals(email, false);
    }

    @Test
    public void userEmailShouldBeValid() throws Exception {
        User user = new User();

        Boolean email = user.isEmailValid("asdasd.com");

        Assert.assertEquals(email, false);
    }

    @Test
    public void userShouldHaveNotSpecialCaracInCPF() throws Exception {
        User user = new User();

        user.cpf="123.123.123-12";

        Assert.assertEquals(user.validateCPF(), "12312312312");
    }

    @Test
    public void userShouldHaveValidCEP() throws Exception {
        User user = new User();

        user.cep="00000-000";

        Assert.assertEquals(user.validateCEP(), "00000000");
    }

    @Test
    public void userShouldHaveAValidCPF() throws Exception {
        User user = new User();

        String cpf = user.cpf="999.999.999-99";
        long count = cpf.chars().filter(new IntPredicate() {
            public boolean test(int ch) {
                return ch == '9';
            }
        }).count();

        Assert.assertEquals(count, 11);
    }

}
