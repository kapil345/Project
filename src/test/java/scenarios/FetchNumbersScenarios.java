package scenarios;

import com.jayway.restassured.response.Response;
import com.plivo.Utils.CommonUtil;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.AllNumbersDAO;
import com.plivo.models.responsemodels.ObjectsDAO;
import com.plivo.services.FetchNumbers;
import org.testng.Assert;
import org.testng.ITestContext;


public class FetchNumbersScenarios extends IScenarios {

    private CommonUtil commonUtil = new CommonUtil();
    private Response response;

    public FetchNumbersScenarios() {
    }

    public void execute() {
        FetchNumbers fetchNumbers = new FetchNumbers();
        response = fetchNumbers.getNumbers();
    }

    public void verify() {
        if (response.statusCode() != 200) {
            Assert.fail("Success Response is not recived from API");
        }
        AllNumbersDAO numbers = ApiHelpers.get_Gson_from_Json(AllNumbersDAO.class, response);
        Assert.assertNotNull(numbers, "response recived from numbers api is null");
        ObjectsDAO[] objs = numbers.getObjects();
        String phonenunber1 = objs[0].getNumber();
        String phonenumber2 = objs[1].getNumber();
        Assert.assertNotNull(phonenunber1, "Phone number is not found");
        Assert.assertNotNull(phonenumber2, "phone number is not found");
        commonUtil.saveNumbers(phonenunber1, phonenumber2);
        new SendMessageScenarios(commonUtil);
    }
}
