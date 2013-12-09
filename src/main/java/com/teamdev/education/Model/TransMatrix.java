package com.teamdev.education.Model;

import java.util.HashMap;

public class TransMatrix {

    public final HashMap<States, States[]> matrix;

    public TransMatrix(){
        HashMap<States, States[]> matrix = new HashMap<States, States[]>();
        matrix.put(States.START, new States[]{States.NUMBER, States.LFT_BR});
        matrix.put(States.NUMBER, new States[]{States.FINISH, States.RHT_BR, States.BIN_OP});
        matrix.put(States.LFT_BR, new States[]{States.NUMBER, States.LFT_BR});
        matrix.put(States.RHT_BR, new States[]{States.FINISH, States.RHT_BR, States.BIN_OP});
        matrix.put(States.BIN_OP, new States[]{States.NUMBER, States.LFT_BR});
        matrix.put(States.FINISH, new States[]{States.FINISH});

        this.matrix = matrix;
    }
}