package com.teamdev.education.UI;

import com.teamdev.education.Services.iOnResult;

import java.math.BigDecimal;

class ResultListener implements iOnResult {
    @Override
    public void onResult(BigDecimal result) {
        System.out.println("result: " + result);
    }
}
