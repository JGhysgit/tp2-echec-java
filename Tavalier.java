import java.util.ArrayList;

class Tavalier extends Piece{

    public Tavalier(){
        super('B', new Position());
    }

    public Tavalier(char couleur, Position position){
        super(couleur, position);
    }

    public String getType(){
        return new String("tavalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl){
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Déplacements du Cavalier
        int[] deplacementsCavalier = {
            -2, -1, -2, 1, -1, 2, 1, 2, 2, 1, 2, -1, 1, -2, -1, -2
        };
        for(int i = 0; i < deplacementsCavalier.length; i += 2){
            int indiceX = positionDepartX + deplacementsCavalier[i];
            int indiceY = positionDepartY + deplacementsCavalier[i + 1];
            if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
                Piece pi = pl.getCase(indiceX, indiceY);
                if(pi == null || pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(indiceX, indiceY));
            }
        }

        // Déplacements de la Tour
        int[][] directionsTour = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        for(int[] direction : directionsTour){
            int indiceX = positionDepartX + direction[0];
            int indiceY = positionDepartY + direction[1];
            while(indiceX >= 0 && indiceX < 8 && indiceY >= 0 && indiceY < 8){
                Piece pi = pl.getCase(indiceX, indiceY);
                if(pi == null){
                    liste.add(new Position(indiceX, indiceY));
                } else {
                    if(pi.getCouleur() != this.getCouleur())
                        liste.add(new Position(indiceX, indiceY));
                    break;
                }
                indiceX += direction[0];
                indiceY += direction[1];
            }
        }
        return liste;
    }
}
