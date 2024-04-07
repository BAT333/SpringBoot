package com.rafael.demo.persistenciaJava.model;

public enum Priority {
    HIGH(1),
    AVERAGE(2),
    LOW(3);
    private int valuepriority;
     Priority(int valuepriority){
        this.valuepriority= valuepriority;
    }
    public Priority selectPriority(int number){
        return switch (number) {
            case 1 -> Priority.HIGH;
            case 2 -> Priority.AVERAGE;
            case 3 -> Priority.LOW;
            default -> throw new RuntimeException("WRONG NUMBER\n");
        };
    }


}
