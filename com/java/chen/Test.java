package com.java.chen;

import java.util.Arrays;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Test sortTest = new Test();
		int[] array = sortTest.createRandArray(999);
		//打印原始随机数组
		System.out.println(Arrays.toString(array));
		
		//ISort sortObj = DirectInsertionSort.getInstance();
		//ISort sortObj = ShellSort.getInstance();
//		ISort sortObj = SelectSort.getInstance();
//		ISort sortObj = BubbleSort.getInstance();
//		ISort sortObj = QuickSort.getInstance();
//		ISort sortObj = MergeSort.getInstance();
//		ISort sortObj = HeapSort.getInstance();
		ISort sortObj = RadixSort.getInstance();
		sortObj.sort(array);
//		DirectInsertionSort.getInstance().sortRecursively(array);
//		DirectInsertionSort.getInstance().binarySort(array);
//		BubbleSort.getInstance().cocktailSock(array);
		
		//打印排序后的数组
		System.out.println(Arrays.toString(array));

	}
	
	private int[] createRandArray(int num)
	{
		if(num <= 0)
		{
			return new int[]{};
		}
		int[] array = new int[num];
		for(int i = 0; i < num; i++)
		{
			array[i] = (int)(Math.random()*num);
		}
		return array;
	}

}
