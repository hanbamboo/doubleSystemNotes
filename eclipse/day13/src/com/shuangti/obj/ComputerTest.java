package com.shuangti.obj;

public class ComputerTest {
	public static void main(String[] args) {
		Computer computer = new Computer();
		Printer csPrinter = new CaiSePrinter();
		Printer hsPrinter = new HeiBaiPrinter();
		
		computer.print(hsPrinter);
		computer.print(csPrinter);


	}
}
