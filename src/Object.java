/**
 * The Object class represents an item that can be placed in the backpack.
 * Each object has a unique number, a value, a weight, and a volume.
 *
 * @author Ricardo Soares - 44375
 * @author Miguel Moreira - 44594
 * @author Manuel Brandão - 38909
 */
public class Object {

    /**
     * The unique number assigned to the object.
     */
    int number;

    /**
     * The value of the object.
     */
    int value;

    /**
     * The weight of the object.
     */
    int weight;

    /**
     * The volume of the object.
     */
    int volume;

    /**
     * Constructor for creating an Object with the specified parameters.
     *
     * @param number The unique number assigned to the object.
     * @param value  The value of the object.
     * @param weight The weight of the object.
     * @param volume The volume of the object.
     */
    public Object(int number, int value, int weight, int volume) {
        this.number = number;
        this.value = value;
        this.weight = weight;
        this.volume = volume;
    }
}
