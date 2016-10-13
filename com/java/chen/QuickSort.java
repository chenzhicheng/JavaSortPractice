package com.java.chen;

//最差时间复杂度 ---- O(n^2),待排序的元素有序时为最差情况,并不多见
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(nlogn)
//所需辅助空间 ------ O(logn)～O(n),主要是递归造成的栈空间的使用(用来保存left和right等局部变量),取决于递归树的深度

public class QuickSort implements ISort {

	private static QuickSort instance;
	
	private QuickSort()
	{
		
	}
	public static  QuickSort getInstance()
	{
		if(instance == null)
		{
			instance = new QuickSort();
		}
		return instance;
	}
	
	private void exchange(int[] a, int  i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private int partition(int[] array, int left, int right)
	{
		int temp = array[left];	//取第一个为基准
		int pivot = left;
		for(int i = left+1; i <= right; i++)
		{
			if(array[i] <= temp)
			{
				pivot ++;
				if(pivot != i)
				{
					exchange(array, i, pivot);
				}
			}
		}
		exchange(array, left, pivot);
		return pivot;
	}
	
	private void quickSort(int[] array, int left, int right)
	{
		int pivot;
		if(left < right)
		{
			pivot = partition(array,left,right);
			quickSort(array, left , pivot-1);
			quickSort(array, pivot+1, right);
		}
	}
	
	@Override
	public void sort(int[] array) {
		quickSort(array, 0, array.length-1);

	}

}
