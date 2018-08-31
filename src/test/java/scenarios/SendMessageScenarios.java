package scenarios;

import com.jayway.restassured.response.Response;
import com.plivo.Utils.CommonUtil;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.AccountDetailsDAO;
import com.plivo.models.responsemodels.MessageDAO;
import com.plivo.services.AccountDetails;
import com.plivo.services.SendMessage;
import org.testng.Assert;

public class SendMessageScenarios extends IScenarios {

    private CommonUtil commonUtil = new CommonUtil();
    private SendMessage sendMessage = new SendMessage();
    private Response response;

    public SendMessageScenarios(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
        getCurrentCreditCash();
        this.run();
    }

    private void getCurrentCreditCash() {
        AccountDetails accountDetails = new AccountDetails();
        response = accountDetails.getAccountDetailsofPlivoAccount();
        AccountDetailsDAO accountDetailsDAO = ApiHelpers.get_Gson_from_Json(AccountDetailsDAO.class, response);
        String currentCashCredit = accountDetailsDAO.getCash_credits();
        this.commonUtil.data.put("current_cash_credit", currentCashCredit);
    }

    @Override
    public void execute() {
        response = sendMessage.sendMessageToGivenNummber(this.commonUtil.getNumbers().get("src"), this.commonUtil.getNumbers().get("dst"));
    }

    @Override
    public void verify() {
        if (response.statusCode() == 202) {
            System.out.println("Message has been successfully sent");
        } else {
            Assert.fail("Messge has not sent");
        }
        MessageDAO messageDAO = ApiHelpers.get_Gson_from_Json(MessageDAO.class, response);
        Assert.assertNotNull(messageDAO);
        Assert.assertNotNull(messageDAO.getMessage_uuid(), "Message uuid is Null");
        Assert.assertEquals(messageDAO.getMessage(), "message(s) queued");
        String m_uuid = messageDAO.getMessage_uuid()[0];
        commonUtil.data.put("uuid", m_uuid);
        new MessageDetailsScenarios(commonUtil);
    }
}
