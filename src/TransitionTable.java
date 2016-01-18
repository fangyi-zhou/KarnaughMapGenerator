/**
 * Created by fangyi on 17/01/2016.
 */
public class TransitionTable {
    private int[] stateRep;
    private int[] transitionsFalse;
    private int[] transitionsTrue;
    private int noOfStates;
    private StateTable sTable;

    public TransitionTable (int noOfStates, int[] transitionsFalse, int[] transitionsTrue, StateTable sTable){
        this.noOfStates = noOfStates;
        this.transitionsFalse = transitionsFalse;
        this.transitionsTrue = transitionsTrue;
        this.stateRep = new int[noOfStates];
        for (int i = 0; i < noOfStates; i++){
            stateRep[i] = i;
        }
        this.sTable = sTable;
    }

    public void updateStateRep (int[] stateRep){
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

    public void show(){
        System.out.println("FRO\t\t\tIN\tD2\tD1\tD0\t\tTO\t\t\tQ2\tQ1\tQ0");
        for (int i = 0; i < noOfStates; i++){
            System.out.println(stateRep[i] + "\t" + sTable.getAlias(i) + "\t\t0\t"
                    + formulateBinaryOutput(BaseConversion.denaryToBinary(stateRep[i]))
                    + "\t" + sTable.getAlias(transitionsFalse[i]) +"\t\t" + stateRep[transitionsFalse[i]] + "\t"
                    + formulateBinaryOutput(BaseConversion.denaryToBinary(stateRep[transitionsFalse[i]])));
            System.out.println(stateRep[i] + "\t" + sTable.getAlias(i) + "\t\t1\t"
                    + formulateBinaryOutput(BaseConversion.denaryToBinary(stateRep[i]))
                    + "\t" + sTable.getAlias(transitionsTrue[i]) + "\t\t" + stateRep[transitionsTrue[i]] + "\t"
                    + formulateBinaryOutput(BaseConversion.denaryToBinary(stateRep[transitionsTrue[i]])));
        }
    }
}
