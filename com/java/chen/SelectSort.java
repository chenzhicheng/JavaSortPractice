package com.java.chen;

//最差时间复杂度 ---- O(n^2)
//最优时间复杂度 ---- O(n^2)
//平均时间复杂度 ---- O(n^2)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 不稳定
public class SelectSort implements ISort {

	private static SelectSort  instance;
	
	private  SelectSort()
	{
		
	}
	public static SelectSort getInstance()
	{
		if(instance == null)
		{
			instance = new SelectSort();
		}
		return instance;
	}
	
	@Override
	public void sort(int[] array) {
		if(array == null || array.length == 1)
		{
			return;
		}
		int i, j, k;
		int temp;
		for(i=0; i<array.length; i++)
		{
			k = i;
			for(j=i+1; j < array.length; j++)
			{
				if(array[j] < array[k])
				{
					k = j;
				}
			}
			if(k!=i)
			{
				temp = array[i];
				array[i] = array[k];
				array[k] = temp;
			}
		}
	}

}
