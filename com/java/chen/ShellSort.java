package com.java.chen;
//希尔排序

//最差时间复杂度 ---- 根据步长序列的不同而不同。已知最好的为O(n(logn)^2)
//最优时间复杂度 ---- O(n)
//平均时间复杂度 ---- 根据步长序列的不同而不同
//所需辅助空间 ------ O(1)
//稳定性 ---------- 不稳定
public class ShellSort implements ISort {

	private static ShellSort instance;
	
	private  ShellSort()
	{
		
	}
	
	public static ShellSort getInstance()
	{
		if(instance == null)
		{
			instance = new ShellSort();
		}
		return instance;
	}
	
	@Override
	public void sort(int[] array) 
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		int d = array.length;	//希尔增量
		int temp;
		while(d>=1)
		{
			d = d / 2;
			for(int x = 0;  x < d; x++)	//遍历所有分组,共d个组
			{
				for(int i = x+d; i < array.length; i+=d)	//对每个分组进行直接插入排序，其中相邻元素相隔d
				{
					temp = array[i];
					int j = i-d;
					for(;j>=0 &&array[j] > temp; j -= d)
					{
						array[j+d] = array[j];
					}
					array[j+d] = temp;
				}
			}
		}

	}


}
