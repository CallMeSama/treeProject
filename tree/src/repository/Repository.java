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
        // On tabule d'abord pour le premier composite
        tabulate(tab, noBranchLevel, prevNoBranchLevel);

        // On affiche le composite
        System.out.println(getName());

        for (Composite child : children) {

            boolean last = child.equals(children.get(children.size() - 1));

            // Si child est le dernier element de composite
            if (last)
                child.show(tab + 1, tab + 1, noBranchLevel);
            else
                // Sinon on continue à afficher la ligne verticale
                child.show(tab + 1, noBranchLevel, prevNoBranchLevel);
        }
    }
}
