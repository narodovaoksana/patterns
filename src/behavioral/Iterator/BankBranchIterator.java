package behavioral.Iterator;

import java.util.List;

public class BankBranchIterator implements Iterator<BankBranch> {
    private List<BankBranch> branchList;
    private int currentPosition;

    public BankBranchIterator(List<BankBranch> branchList) {
        this.branchList = branchList;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < branchList.size();
    }

    @Override
    public BankBranch next() {
        if (hasNext()) {
            BankBranch branch = branchList.get(currentPosition);
            currentPosition++;
            return branch;
        }
        return null;
    }
}
