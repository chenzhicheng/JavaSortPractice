package com.java.chen;

//基数排序
//最差时间复杂度 ---- O(n * dn)
//最差空间复杂度 ---- O(n * dn)
public class RadixSort implements ISort {

	private static RadixSort instance;
	private RadixSort()
	{
		
	}
	
	public static RadixSort getInstance()
	{
		if(instance == null)
		{
			instance = new RadixSort();
		}
		return instance;
	}
	@Override
	public void sort(int[] array) {
		
		lsd_radixsort(array);
		
//		radixSort(array);
	}
	
	private int getMaxValue(int[] array)
	{
		int maxValue = array [0];
		for(int value : array)
		{
			if(value > maxValue)
			{
				maxValue = value;
			}
		}
		return maxValue;
	}
	
	private int getMaxBit(int maxValue)
	{
		int cnt = 0;
		while(maxValue > 0)
		{
			maxValue /= 10;
			cnt ++;
		}
		return cnt;
	}
	
	private int getDigit(int value, int d)// 获得元素的第d位数字
	{
		return ((int) (value/Math.pow(10,d-1)))%10;
	}
	
	private void countingSort(int[] array, int[] temp, int d)// 应用计数排序(依据元素的第d位数字)对元素排序
	{
		int[] cntArr = new int[]{0,0,0,0,0,0,0,0,0,0};
		for(int i = 0; i < array.length; i++)	 // 使cntArr[i]保存着当前位等于i的元素个数
		{
			cntArr[getDigit(array[i], d)] ++;
		}
		for(int i = 1; i < 10; i++)	 //使cntArr[i]保存着当前位小于等于i的元素个数,排序后元素i就放在第cntArr[i]个输出位置上
		{
			cntArr[i] += cntArr[i-1];
		}
		 for (int i = array.length - 1; i >= 0; i--)// 从后向前扫描保证计数排序的稳定性(重复元素相对次序不变)
	    {
	        int digit = getDigit(array[i], d);   
	        temp[cntArr[digit] - 1] = array[i];            // 根据当前位数字,把每个元素array[i]放到它在输出数组temp中的正确位置上
	        cntArr[digit]--;                 // 当再遇到当前位数字同为digit的元素时,会将其放在当前元素的前一个位置上保证计数排序的稳定性
	    }
	}
	
	private void lsd_radixsort(int[] array)	 // 最低位优先基数排序
	{
		if(array == null || array.length == 1)
		{
			return;
		}
		int[] tempArr = new int[array.length];
		int dn = getMaxBit(getMaxValue(array));
		for(int d = 1; d <= dn; d++)	 // 从最低位开始到最高位
		{
			countingSort(array, tempArr, d);
			for(int i = 0; i < array.length; i++)
			{
				array[i] = tempArr[i];
			}
		}
	}
	
	
	
	//另一种实现方法
	private void radixSort(int[] array)
	{
		int d =  getMaxBit(getMaxValue(array));
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][array.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < array.length; i++)
            {
                int lsd = ((array[i] / n) % 10);
                temp[lsd][order[lsd]] = array[i];
                order[lsd]++;
            }
            for(int i = 0,k=0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++,k++)
                    {
                    	array[k] = temp[i][j];
                    }
                order[i] = 0;
            }
            n *= 10;
            m++;
        }
	}

}

