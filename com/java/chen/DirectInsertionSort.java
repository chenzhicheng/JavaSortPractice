package com.java.chen;

//直接插入排序

public class DirectInsertionSort implements ISort
{
	
	private static DirectInsertionSort instance;
	
	private DirectInsertionSort()
	{
		
	}
	
	public static DirectInsertionSort getInstance()
	{
		if(instance == null)
		{
			instance = new DirectInsertionSort();
		}
		return instance;
	}
	
	//最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
	//最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
	//平均时间复杂度 ---- O(n^2)
	//所需辅助空间 ------ O(1)
	//稳定性 ------------ 稳定
	@Override
	public void sort(int[] array)
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		int temp;
		for(int i = 1; i < array.length; i++)
		{
			temp = array[i];
			int j = i-1;
			for(; j >= 0 && array[j] > temp; j--)
			{
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
	}
	
	/**
	 * 递归实现
	 * @param array
	 */
	public void sortRecursively(int[] array)
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		recursiveSort(array, 1);
	}
	
	private void recursiveSort(int[] array, int index)
	{
		if(index <= 0 || index >= array.length)
		{
			return;
		}
		int temp = array[index];
		int j = index - 1;
		for(; j>=0 && array[j] > temp; j--)
		{
			array[j+1] = array[j];
		}
		array[j+1] = temp;
		recursiveSort(array, index + 1);
	}
	
	// 最差时间复杂度 ---- O(n^2)
	// 最优时间复杂度 ---- O(nlogn)
	// 平均时间复杂度 ---- O(n^2)
	// 所需辅助空间 ------ O(1)
	// 稳定性 ------------ 稳定
	/**
	 * 二分插入
	 */
	public void binarySort(int[] array)
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		int j, left, right, middle;
		int temp;
		for(int i = 1; i < array.length; i++)
		{
			//先用二分查找确定要插入的位置
			temp = array[i];
			left = 0;
			right = i - 1;
			while(left <= right)
			{
				middle = (left + right) / 2;
				if(temp < array[middle])
				{
					right = middle - 1;
				}
				else
				{
					left = middle + 1;
				}
			}
			//left为要插入的位置
			for(j = i - 1; j >= left; j--)
			{
				array[j+1] = array[j];
			}
			array[left] = temp;
		}
	}
}
