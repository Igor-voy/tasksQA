import org.testng.annotations.DataProvider;
import utils.JsonDataReader;
import utils.UserData;
import java.util.List;

public class TestDataProvider {
    @DataProvider(name = "userData")
    public Object[][] provideUserData() {
        List<UserData> userDataList = JsonDataReader.readTestData();
        Object[][] data = new Object[userDataList.size()][1];
        for (int i = 0; i < userDataList.size(); i++) {
            data[i][0] = userDataList.get(i);
        }
        return data;
    }
}
