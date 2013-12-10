package com.teamdev.education.UI;

import com.teamdev.education.Services.Calculation;

public class ExpressionListener implements iOnExpressionInput {
    @Override
    public void OnExprInput(String expression) {
        new Calculation(expression);
    }
}
