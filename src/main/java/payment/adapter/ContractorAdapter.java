package payment.adapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public abstract class ContractorAdapter {
    private final Float amountToPay;

    protected abstract String buildPaymentRequest();
    protected abstract boolean parseContractorResponse(String body);
    public abstract boolean pay() throws InterruptedException;

    protected ContractorAdapter(Float amountToPay) {
        this.amountToPay = amountToPay;
    }

    public String sendPaymentRequest()  {
        try {
            URL paypalURL = new URL(buildPaymentRequest());
            URLConnection connection = paypalURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine, response = new String();
            while ((inputLine = in.readLine()) != null)
                response+=inputLine;
            in.close();
            return response;
        } catch (MalformedURLException e) {
            return "MALFORMED_URL_ERROR";
        } catch (IOException e) {
            return "UNREACHABLE";
        }
    }

    public Float getAmountToPay() {
        return amountToPay;
    }
}
