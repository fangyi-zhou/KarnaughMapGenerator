/**
 * Created by fangyi on 17/01/2016.
 */
public class KarnaughMapGenerator {

    static TransitionTable tTable;
    static StateTable sTable;

    private static void readData(){
        System.out.println("Please enter the number of states:");
        int noOfStates = IOUtil.readInt();
        sTable = new StateTable(noOfStates);
        for (int i = 0; i < noOfStates; i++) {
            System.out.println("Please enter the alias for State " + i + ":" );
            sTable.setAlias(i, IOUtil.readString());
        }
        int[] stateRep = new int[noOfStates];
        int[] transitionsTrue = new int[noOfStates];
        int[] transitionsFalse = new int[noOfStates];
        for (int i = 0; i < noOfStates; i++) {
            System.out.println("Please enter the destination state for "+ sTable.getAlias(i) + " for a true input:");
            transitionsTrue[i] = sTable.getState(IOUtil.readString());
            while (transitionsTrue[i] < 0) {
                System.out.println("Invalid input, try again");
                transitionsTrue[i] = sTable.getState(IOUtil.readString());
            }
            System.out.println("Please enter the destination state for "+ sTable.getAlias(i) + " for a false input:");
            transitionsFalse[i] = sTable.getState(IOUtil.readString());
            while (transitionsFalse[i] < 0) {
                System.out.println("Invalid input, try again");
                transitionsFalse[i] = sTable.getState(IOUtil.readString());
            }
            System.out.println("Please enter the state representation for "+ sTable.getAlias(i) + ":");
            stateRep[i] = IOUtil.readInt();
        }
        tTable = new TransitionTable(noOfStates, transitionsFalse, transitionsTrue, sTable);
        tTable.updateStateRep(stateRep);
    }

    private static void modifyStateRep(){
        int noOfStates = sTable.getNoOfStates();
        int[] stateRep = new int[noOfStates];
        for (int i = 0; i < noOfStates; i++) {
            System.out.println("Please enter the state representation for "+ sTable.getAlias(i) + ":");
            stateRep[i] = IOUtil.readInt();
        }
        tTable.updateStateRep(stateRep);
    }

    public static void main(String[] args){
        readData();
        boolean loop = false;
        do {
            if (loop){
                modifyStateRep();
            }
            tTable.show();
            KarnaughMap kMap = new KarnaughMap (tTable);
            kMap.show();
            System.out.println("Do you wish to change the state representations?");
            char changeStateRep = IOUtil.readString().charAt(0);
            loop = changeStateRep == 'y';
        } while (loop);
    }
}
