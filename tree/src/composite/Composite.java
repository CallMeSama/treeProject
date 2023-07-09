
package src.composite;

public abstract class Composite {

    private String name;

    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract void show(int tab, int noBranchLevel, int prevNoBranchLevel);

    public void addChild(Composite child) {
    }

    public void tabulate(int tab, int noBranchLevel, int prevNoBranchLevel) {

        // Cette variable permet d'afficher les espaces qui definissent la tabulation
        // Tabulation en fonction des parents
        // Chaque tabulation se fait par 3 espaces
        int newtab = tab < 1 ? 0 : 3 * tab;

        for (int i = 0; i < newtab; i++) {
            // Pour chaque debut de tabulation on affiche une barre verticale sauf si on
            // ateint un composite qui n'a pas de sous composite enfant

            if (i % 3 == 0 && (i > noBranchLevel * 3 || (i > prevNoBranchLevel * 3 && i < noBranchLevel * 3)))
                System.out.print("\u2502");
            // sinon on affiche un espace
            else
                System.out.print(" ");
        }

        // Si c'est composite sans sous éléments alors on affiche un trait angulaire
        if (tab == noBranchLevel)
            System.out.print("\u2514\u2500\u2500");
        // Sinon on affiche un caratère un peu similaire à une crois
        else
            System.out.print("\u251C\u2500\u2500");

    }
}