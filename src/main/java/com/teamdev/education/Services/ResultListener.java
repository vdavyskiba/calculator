package com.teamdev.education.Services;

import java.math.BigDecimal;

public class ResultListener implements iOnResult {
    @Override
    public void onResult(BigDecimal result) {
        System.out.println("result: " + result);
    }
}
