// abstract class, as a Transport cannot be created
abstract class Transport {
}

// abstract class, as it might have properties but cannot be instanciated
abstract class RoadVehicle extends Transport implements Refuelable {
  int wheelCount;
}

// interface as only contains methods and cannot be instanciated
interface Refuelable {
  void refill();
}

// interface as only contains methods and cannot be instanciated
interface Cycle {
  void cycle();
}

// class, as a Train can be instanciated
class Train extends Transport {
}

// class as a Tricycle can be instanciated
class Tricycle extends Transport implements Cycle {
}

// class as a Bicycle can be instanciated
class Bicycle extends Transport implements Cycle {
}

// a car can be instanciated, so it has to be a class
class Car extends RoadVehicle {
}

// jetplane can also be instanciated, therefore it's a class
class JetPlane extends Transport implements Refuelable {
}
