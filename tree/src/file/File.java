package src.file;

import src.composite.Composite;

public class File extends Composite {

    public File(String name) {
        super(name);
    }

    @Override
    public void show(int tab, int noBranchLevel, int prevNoBranchLevel) {
        tabulate(tab, noBranchLevel, prevNoBranchLevel);
        System.out.println(this.getName());
    }
}
