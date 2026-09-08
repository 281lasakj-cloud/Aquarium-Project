public class ReferenceLab {

    public static void main(String[] args) {

        // ==================================================
        // EXPERIMENT A: ALIASING
        // ==================================================

        SeaCreature nemo = null;
        try {
            nemo = new Fish("Nemo", 5, 3, 1, "><>");
        } catch (InvalidCreatureException e) {
            e.printStackTrace();
        }
        SeaCreature copy = nemo;

        // PREDICT BEFORE RUNNING:
        // What will copy.getPosition() return after nemo.setPosition(25)?
        //copy is refered to nemo, so if you change nemo then
        //copy will also have the same position
        nemo.setPosition(25);

        System.out.println("Experiment A - Aliasing");
        System.out.println("nemo position: " + nemo.getPosition());
        System.out.println("copy position: " + copy.getPosition());

        //I was correct, when you do copy = nemo, copy now has a
        //pointer at nemo
        // ==================================================
        // EXPERIMENT B: TWO DIFFERENT OBJECTS
        // ==================================================

        SeaCreature fish1 = null;
        SeaCreature fish2 = null;
        try {
            fish1 = new Fish("Fish", 10, 2, 1, "><>");
            fish2 = new Fish("Fish", 10, 2, 1, "><>");
        } catch (InvalidCreatureException e) {
            e.printStackTrace();
        }

        // PREDICT BEFORE RUNNING:
        // Will fish1 == fish2 be true or false?
        //False because when you compare objects they are looking
        //if they are the exact same object or not
        System.out.println();
        System.out.println("Experiment B - Separate Objects");
        System.out.println("fish1 == fish2: " + (fish1 == fish2));

        //Was right this was false
        // ==================================================
        // EXPERIMENT C: ARRAY REFERENCES
        // ==================================================

        SeaCreature[] tank = new SeaCreature[5];
        try {
            tank[0] = new Fish("Bubbles", 8, 1, 1, "><((('>");
        } catch (InvalidCreatureException e) {
            e.printStackTrace();
        }

        SeaCreature selected = tank[0];

        // PREDICT BEFORE RUNNING:
        // What happens to tank[0] if selected is modified?
        //I think tank will change to what selected is
        selected.setPosition(35);

        System.out.println();
        System.out.println("Experiment C - Array References");
        System.out.println("selected position: " + selected.getPosition());
        System.out.println("tank[0] position: " + tank[0].getPosition());
        //tank[0] is the same as selected after it was change which
        //proves that if you change the variable referring to that position
        //and tank[0] points to that position it will also change
    }
}
