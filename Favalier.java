import java.util.ArrayList;

class Favalier extends Piece {

    public Favalier() {
        super('B', new Position());
    }

    public Favalier(char couleur, Position position) {
        super(couleur, position);
    }

    public String getType() {
        return "favalier";
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<>();

        // Déplacements comme un fou
        Fou tempFou = new Fou(this.getCouleur(), this.getPosition());
        liste.addAll(tempFou.getDeplacementPossible(pl));

        // Déplacements comme un cavalier
        Cavalier tempCavalier = new Cavalier(this.getCouleur(), this.getPosition());
        ArrayList<Position> cavDepl = tempCavalier.getDeplacementPossible(pl);

        // Éviter les doublons (optionnel, si nécessaire)
        for (Position pos : cavDepl) {
            if (!liste.contains(pos)) {
                liste.add(pos);
            }
        }

        return liste;
    }
}
