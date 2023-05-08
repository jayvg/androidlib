package com.example.totolib;

import com.warrenstrange.googleauth.*;

import java.util.concurrent.TimeUnit;

public class TOTPUtils {

    public static void main(String args[]) {

        int totpCode = getTOTP();
        System.out.println("totp is " + totpCode);

    }

    public static int getTOTP(){
        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig.GoogleAuthenticatorConfigBuilder()
                .setHmacHashFunction(HmacHashFunction.HmacSHA256)
                .setTimeStepSizeInMillis(TimeUnit.SECONDS.toMillis(30))
                .build();

        GoogleAuthenticator ga = new GoogleAuthenticator(config);
        String secretKey = "JBSWY3DPEHPK3PXP";
        int totpCode = ga.getTotpPassword(secretKey);
        return totpCode;
    }
}
