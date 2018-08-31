package scenarios;

import com.jayway.restassured.response.Response;
import com.plivo.Utils.CommonUtil;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.SentMessageDetailsDAO;
import com.plivo.services.SentMessageDetails;
import org.testng.Assert;

public class MessageDetailsScenarios extends IScenarios {


    private CommonUtil commonUtil = new CommonUtil();
    private Response response;

    public MessageDetailsScenarios(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
        this.run();
    }

    @Override
    public void execute() {
        SentMessageDetails sentMessageDetails = new SentMessageDetails();
        response = sentMessageDetails.getSentMessagePricingData(this.commonUtil.data.get("uuid"));
    }

    @Override
    public void verify() {

        if (response.statusCode() == 200) {
            System.out.println("Sucessfully Fetched sent message");
        } else {
            Assert.fail("Sent message details not present");
        }
        SentMessageDetailsDAO sentMessageDetailsDAO = ApiHelpers.get_Gson_from_Json(SentMessageDetailsDAO.class, response);
        Assert.assertNotNull(sentMessageDetailsDAO);
        Assert.assertNotNull(sentMessageDetailsDAO.getApi_id());
        Assert.assertEquals(sentMessageDetailsDAO.getFrom_number(), commonUtil.data.get("src"));
        Assert.assertEquals(sentMessageDetailsDAO.getMessage_state(), "sent");
        Assert.assertEquals(sentMessageDetailsDAO.getMessage_type(), "sms");
        Assert.assertEquals(sentMessageDetailsDAO.getMessage_uuid(), commonUtil.data.get("uuid"));
        Assert.assertEquals(sentMessageDetailsDAO.getMessage_direction(), "outbound");
        commonUtil.data.put("total_rate", sentMessageDetailsDAO.getTotal_rate());
        new PricingScenarios(commonUtil);
    }


}
