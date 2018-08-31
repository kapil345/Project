package scenarios;

import com.jayway.restassured.response.Response;
import com.plivo.Utils.CommonUtil;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.AccountDetailsDAO;
import com.plivo.services.AccountDetails;
import org.testng.Assert;

import java.text.DecimalFormat;

public class AccountDetailsScenarios extends IScenarios {

    private CommonUtil commonUtil = new CommonUtil();
    private Response response;

    private AccountDetailsScenarios(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
        this.run();
    }

    @Override
    public void execute() {
        AccountDetails accountDetails = new AccountDetails();
        response = accountDetails.getAccountDetailsofPlivoAccount();
    }

    @Override
    public void verify() {
        if (response.statusCode() == 200) {
            System.out.println("your plivo account details has been fetched***");
        } else
            Assert.fail("Account detail api is failing");
        AccountDetailsDAO accountDetailsDAO = ApiHelpers.get_Gson_from_Json(AccountDetailsDAO.class, response);
        String creditafterDeduction = accountDetailsDAO.getCash_credits();
        String creditBeforeDeduction = commonUtil.data.get("current_cash_credit");
        float difference;
        difference = Float.parseFloat(creditBeforeDeduction) - Float.parseFloat(creditafterDeduction);
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        double ans = Double.valueOf(twoDForm.format(difference));
        Assert.assertTrue(ans > 0);
        Float actualRate = Float.parseFloat(commonUtil.data.get("total_rate"));
        Double finalRate = Double.valueOf(twoDForm.format(actualRate));
        Assert.assertEquals(ans, finalRate);
    }
}
