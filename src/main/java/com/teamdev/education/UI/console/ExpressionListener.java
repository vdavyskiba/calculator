package com.teamdev.education.UI.console;

import com.teamdev.education.Services.Calculation;
import com.teamdev.education.UI.console.ResultListener;

public class ExpressionListener {

    public void OnExprInput(String expression) {
        new Calculation(expression, new ResultListener());
    }
}
