package com.project.bookstore.controller;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.InputFields;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.api.payments.WebProfile;
import com.paypal.base.rest.PayPalRESTException;
import com.project.bookstore.service.PaypalService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/tier3")
public class PaymentController {

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    @GetMapping(value = "/pay")
    public String pay(HttpServletRequest request) {
//        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
//        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
//        try {
//            Payment payment = paypalService.createPayment(
//                    4.00,
//                    "USD",
//                    PaypalPaymentMethod.paypal,
//                    PaypalPaymentIntent.sale,
//                    "payment description",
//                    cancelUrl,
//                    successUrl);
//            for (Links links : payment.getLinks()) {
//                if (links.getRel().equals("approval_url")) {
//                    return "redirect:" + links.getHref();
//                }
//            }
//        } catch (PayPalRESTException e) {
//            log.error(e.getMessage());
//        }
//        return "redirect:/";

        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

// Set redirect URLs
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:3000/cancel");
        redirectUrls.setReturnUrl("http://localhost:3000/process");

// Set payment details
        Details details = new Details();
        details.setShipping("1");
        details.setSubtotal("5");
        details.setTax("1");

// Payment amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
// Total must be equal to sum of shipping, tax and subtotal.
        amount.setTotal("7");
        amount.setDetails(details);

// Transaction information
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction
                .setDescription("This is the payment transaction description.");

// Add transaction to a list
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

// Add payment details
        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setRedirectUrls(redirectUrls);
        payment.setTransactions(transactions);
        payment.setExperienceProfileId(PAYPAL_CANCEL_URL);

//        Set no shipping
        WebProfile webProfile = new WebProfile();
        InputFields inputfield = new InputFields();
        inputfield.setNoShipping(1);
        webProfile.setInputFields(inputfield);
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

}
