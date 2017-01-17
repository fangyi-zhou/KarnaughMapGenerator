class TransitionTable {
    private int[] stateRep;
    private int[] transitionsFalse;
    private int[] transitionsTrue;
    private int noOfStates;
    private StateTable sTable;

    TransitionTable (int noOfStates, int[] transitionsFalse, int[] transitionsTrue, StateTable sTable){
        this.noOfStates = noOfStates;
        this.transitionsFalse = transitionsFalse;
        this.transitionsTrue = transitionsTrue;
        this.stateRep = new int[noOfStates];
        for (int i = 0; i < noOfStates; i++){
            stateRep[i] = i;
        }
        this.sTable = sTable;
    }

    void updateStateRep (int[] stateRep){
        this.stateRep = stateRep;
    }

    private String formulateBinaryOutput(boolean[] binary){
        StringBuilder sb = new StringBuilder();
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i]) {
                sb.append("1\t");
            } else {
                sb.append("0\t");
            }
        }
        return sb.toString();
    }

    boolean[][] getTransitions(){
        boolean[][] transitions = new boolean[2 * noOfStates][7];
        for (int i = 0; i < noOfStates; i++) {
            transitions[2 * i][0] = false;     //DATA = 0
            transitions[2 * i + 1][0] = true;  //DATA = 1
            boolean[] binaryFrom = BaseConversion.decimalToBinary(stateRep[i]);
            boolean[] binaryToFalse = BaseConversion.decimalToBinary(stateRep[transitionsFalse[i]]);
            boolean[] binaryToTrue = BaseConversion.decimalToBinary(stateRep[transitionsTrue[i]]);
            for (int j = 0; j < 3; j++) {
                transitions[2 * i][j + 1] = binaryFrom[2 - j];
                transitions[2 * i + 1][j + 1] = binaryFrom[2 - j];
                transitions[2 * i][j + 4] = binaryToFalse[2 - j];
                transitions[2 * i + 1][j + 4] = binaryToTrue[2 - j];
            }
        }
        return transitions;
    }

    void show(){
        System.out.println("FROM\t\t\tIN\tQ2\tQ1\tQ0\t\tTO\t\t\tD2\tD1\tD0");
        for (int i = 0; i < noOfStates; i++){
            System.out.println(stateRep[i] + "\t" + sTable.getAlias(i) + "\t\t0\t"
                    + formulateBinaryOutput(BaseConversion.decimalToBinary(stateRep[i]))
                    + "\t" + stateRep[transitionsFalse[i]] + "\t" + sTable.getAlias(transitionsFalse[i]) +"\t\t"
                    + formulateBinaryOutput(BaseConversion.decimalToBinary(stateRep[transitionsFalse[i]])));
            System.out.println(stateRep[i] + "\t" + sTable.getAlias(i) + "\t\t1\t"
                    + formulateBinaryOutput(BaseConversion.decimalToBinary(stateRep[i]))
                    + "\t" + stateRep[transitionsTrue[i]] + "\t" + sTable.getAlias(transitionsTrue[i]) + "\t\t"
                    + formulateBinaryOutput(BaseConversion.decimalToBinary(stateRep[transitionsTrue[i]])));
        }
    }
}
