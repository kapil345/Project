package scenarios;

import com.jayway.restassured.response.Response;
import com.plivo.Utils.CommonUtil;
import com.plivo.helpers.ApiHelpers;
import com.plivo.models.responsemodels.PricingDAO;
import com.plivo.services.Pricing;
import org.testng.Assert;

public class PricingScenarios extends IScenarios {
    CommonUtil commonUtil = new CommonUtil();
    Response response;

    public PricingScenarios(CommonUtil commonUtil) {
        this.commonUtil = commonUtil;
        this.run();
    }

    @Override
    public void execute() {
        Pricing pricing = new Pricing();
        response = pricing.getPricingData();
    }

    @Override
    public void verify() {
        if (response.statusCode() == 200) {
            System.out.println("Pricing has been fetched succussfully");
        } else
            Assert.fail("Pricing api is not working");
        PricingDAO pricingDAO = ApiHelpers.get_Gson_from_Json(PricingDAO.class, response);
        Assert.assertEquals(pricingDAO.getCountry_iso(), "US");
        String outboundRate = pricingDAO.getMessage().getOutbound().getRate();
        //price verification
        Assert.assertEquals(outboundRate, commonUtil.data.get("total_rate"));
        commonUtil.data.put("outbound_rate", outboundRate);
        new AccountDetailsScenarios(commonUtil);
    }
}
