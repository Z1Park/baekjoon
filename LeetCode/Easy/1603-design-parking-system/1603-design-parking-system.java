class ParkingSystem {
    
    private int big;
    private int medium;
    private int small;
    private Map<Integer, Integer> parkingMap = new HashMap<>();

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
        
        parkingMap.put(1, 0);
        parkingMap.put(2, 0);
        parkingMap.put(3, 0);
    }
    
    private int getLimit(int carType) {
        return switch (carType) {
            case 1 -> big;
            case 2 -> medium;
            case 3 -> small;
            default -> -1;
        };
    }
    
    public boolean addCar(int carType) {
        int parkingCount = parkingMap.get(carType);
        if (parkingCount == getLimit(carType))
            return false;
        parkingMap.put(carType, parkingCount + 1);
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */