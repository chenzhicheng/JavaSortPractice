package com.java.chen;

//归并排序
//最差时间复杂度 ---- O(nlogn)
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(nlogn)
//所需辅助空间 ------ O(n)
//稳定性 ------------ 稳定
public class MergeSort implements ISort {

	private static MergeSort instance;
	
	private MergeSort()
	{
		
	}
	
	public static MergeSort getInstance()
	{
		if(instance == null)
		{
			instance = new MergeSort();
		}
		return instance;
	}
	
	@Override
	public void sort(int[] array) {
		mergeSort(array, 0,array.length - 1);
//		mergeSortIteration(array, 0,array.length - 1);
	}
	
	//递归实现，自顶向下
	private void mergeSort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int center = (left + right) / 2;
			mergeSort(array, left, center);
			mergeSort(array,  center+1, right);
			merge(array, left, center, right);
		}
	}
	
	//迭代实现，自底向上
	private void mergeSortIteration(int[] array, int left, int right)
	{
		int low, middle, high;//分两个子数组array[low,middle],array[middle+1,high]
		for(int size = 1; size <= right-left; size *= 2)
		{
			low = left;
			while(low+size-1 <= right-1)
			{
				middle = low+size-1;
				high = middle + size;
				if(high > right)
				{
					high = right;
				}
				merge(array, low, middle, high);
				low = high + 1;
			}
		}
	}
	
	//合并两个已排序的数组array[left,center],array[center+1,right]
	private void merge(int[] array, int left, int center, int right)
	{
		int[] tempArr = new int[array.length];
		int first = left, second = center+1;
		int third = left;
		while(first <= center && second <= right)
		{
			if(array[first] <= array[second])
			{
				tempArr[third++] = array[first++];
			}
			else
			{
				tempArr[third++] = array[second++];
			}
		}
		//把剩余的复制到辅助数组
		while(first<=center)
		{
			tempArr[third++] = array[first++];
		}
		while(second<=right)
		{
			tempArr[third++] = array[second++];
		}
		//把辅助数组排好序的元素复制回原数组
		for(third = left; third<=right; third++)
		{
			array[third] = tempArr[third];
		}
	}

}
