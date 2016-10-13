package com.java.chen;

//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 稳定


public class BubbleSort implements ISort {

	private static BubbleSort instance;
	
	private BubbleSort()
	{
		
	}
	public static BubbleSort getInstance()
	{
		if(instance == null)
		{
			instance = new BubbleSort();
		}
		return instance;
	}
	
	private void exchange(int[] a, int  i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	@Override
	public void sort(int[] array) {
		if(array == null || array.length == 1)
		{
			return;
		}
		for(int i = 0; i< array.length - 1; i++)
		{
			boolean tag = false;
			for(int j = 0; j <array.length - 1 - i ; j++)
			{
				if(array[j] > array[j+1])
				{
					exchange(array, j, j+1);
					tag = true;
				}
			}
			if(!tag)
			{
				break;
			}
		}

	}
	
	//定向冒泡排序(鸡尾酒排序)
	public void cocktailSock(int[] array)
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right)
		{
			boolean tag = false;
			for(int i = left; i < right; i++)
			{
				if(array[i] > array[i+1])
				{
					exchange(array, i, i+1);
					tag = true;
				}
			}
			if(!tag)
			{
				break;
			}
			right -- ;
			for(int i = right; i > left; i--)
			{
				if(array[i] < array[i-1])
				{
					exchange(array, i, i-1);
					tag = true;
				}
			}
			if(!tag)
			{
				break;
			}
			left ++;
			
		}
	}

}
