package src.repository;

import java.util.ArrayList;

package src.repository;

import java.util.ArrayList;

import src.composite.Composite;

public class Repository extends Composite {

    ArrayList<Composite> children = new ArrayList<Composite>();

    public Repository(String name) {
        super(name);
    }

    public void addChild(Composite child) {
        this.children.add(child);
    }

    @Override
    public void show(int tab, int noBranchLevel, int prevNoBranchLevel) {

        tabulate(tab, noBranchLevel, prevNoBranchLevel);
        System.out.println(getName());

        for (Composite child : children) {

            boolean last = child.equals(children.get(children.size() - 1));
            if (last)
                child.show(tab + 1, tab + 1, noBranchLevel);
            else
                child.show(tab + 1, noBranchLevel, prevNoBranchLevel);
        }
    }
}
