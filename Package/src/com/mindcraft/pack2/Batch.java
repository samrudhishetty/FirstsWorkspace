package com.mindcraft.pack2;

public class Batch {
	private String courseName ;
    private int batchStrength;
    
    public Batch() {
    	courseName = "DSA";
    	batchStrength = 15;
    }
    
    public void show() {
    	System.out.println(courseName+" "+batchStrength);
    }
}
