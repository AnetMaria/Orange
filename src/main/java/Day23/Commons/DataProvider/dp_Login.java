package Day23.Commons.DataProvider;

import org.testng.annotations.DataProvider;

public class dp_Login {
    @DataProvider(name="InvalidLoginData")
    public static Object[][]dataProvider(){

        return new Object[][]{

                {"Anet","lazyGal202"},
                {"Bala","CrazyCatLady13"},
                {"Sachin","FriendOfJesus25"}
        };
    }
}
