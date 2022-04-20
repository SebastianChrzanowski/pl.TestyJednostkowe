package testing;

public class Homework {
}

package pl.devfoundry.testing.homework;

        import java.util.Objects;

public class Coordinates {

    private int x;
    private int y;

    Coordinates(int x, int y) {

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Position can not be less than 0");
        }

        if (x > 100 || y > 100) {
            throw new IllegalArgumentException("Position can not be more than 100");
        }

        this.x = x;
        this.y = y;
    }

    static Coordinates copy(Coordinates coordinates, int x, int y) {
        return new Coordinates(coordinates.x + x, coordinates.y + y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}


package pl.devfoundry.testing.homework;

        import java.util.Objects;

public class Cargo {
    private String name;
    private int weight;

    Cargo(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return weight == cargo.weight &&
                Objects.equals(name, cargo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }


    int getWeight() {
        return weight;
    }
}


package pl.devfoundry.testing.homework;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Random;

public class Unit {

    private static Random random = new Random();

    private Coordinates coordinates;
    private int fuel;
    private int maxFuel;
    private List<Cargo> cargo;
    private int maxCargoWeight;
    private int currentCargoWeight;

    Unit(Coordinates startCoordinates, int maxFuel, int maxCargoWeight) {

        this.coordinates = startCoordinates;
        this.maxFuel = maxFuel;
        this.fuel = maxFuel;
        this.maxCargoWeight = maxCargoWeight;
        this.currentCargoWeight = 0;
        this.cargo = new ArrayList<>();

    }

    Coordinates move(int x, int y) {

        if (this.fuel - (x + y) < 0) {
            throw new IllegalStateException("Unit cannot move that far");
        }

        Coordinates coordinatesAfterMove = Coordinates.copy(this.coordinates, x, y);
        this.coordinates = coordinatesAfterMove;

        this.fuel = this.fuel - (x + y);

        return coordinatesAfterMove;
    }

    void tankUp() {

        int restPoints = random.nextInt(10);

        if (restPoints + this.fuel >= maxFuel) {
            this.fuel = maxFuel;
        } else {
            this.fuel += restPoints;
        }

    }

    void loadCargo(Cargo cargo) {

        if (currentCargoWeight + cargo.getWeight() > maxCargoWeight) {
            throw new IllegalStateException("Can not load any more cargo");
        }

        this.cargo.add(cargo);

        this.currentCargoWeight = calculateCargoWeight();

    }

    void unloadCargo(Cargo cargo) {
        this.cargo.remove(cargo);
        this.currentCargoWeight = calculateCargoWeight();
    }

    void unloadAllCargo() {
        cargo.clear();
        this.currentCargoWeight = 0;
    }


    private int calculateCargoWeight() {
        return cargo.stream().mapToInt(Cargo::getWeight).sum();
    }

    int getFuel() {
        return this.fuel;
    }

    int getLoad() {
        return this.currentCargoWeight;
    }
}