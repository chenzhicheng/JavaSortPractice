package com.java.chen;

//堆排序
//最差时间复杂度 ---- O(nlogn)
//最优时间复杂度 ---- O(nlogn)
//平均时间复杂度 ---- O(nlogn)
//所需辅助空间 ------ O(1)
//稳定性 ------------ 不稳定
public class HeapSort implements ISort {

private static HeapSort instance;
	
	private HeapSort()
	{
		
	}
	
	public static HeapSort getInstance()
	{
		if(instance == null)
		{
			instance = new HeapSort();
		}
		return instance;
	}
	
	@Override
	public void sort(int[] array) {
		buildMaxHeap(array);
		for(int i = array.length - 1; i > 0; i--)
		{
			exchange(array, 0, i);	//堆的最后一个元素与根结点交换
			heapify(array, 0, i);		//从根结点开始调整，索引为i的元素从堆去掉，堆大小为i
		}

	}
	
	//构建最大堆
	private void buildMaxHeap(int[] array)
	{
		int lastIndex = (array.length>>1)-1;	//最后一个非叶节点的索引
		for(int i = lastIndex; i>=0; i--)	//从最后一个父节点到根节点依次进行堆调整
		{
			heapify(array, i, array.length);
		}
	}
	
	private void exchange(int[] a, int  i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//最大堆调整(自上而下)
	private void heapify(int[] array, int pIndex, int heapSize)
	{
		int leftChildIndex = (pIndex<<1)+1;
		int rightChildIndex = (pIndex<<1)+2;
		int largest = pIndex;
		if(leftChildIndex < heapSize && array[largest] < array[leftChildIndex])
		{
			largest = leftChildIndex;
		}
		if(rightChildIndex < heapSize && array[largest] < array[rightChildIndex])
		{
			largest = rightChildIndex;
		}
		if(largest != pIndex)
		{
			exchange(array, largest, pIndex);
			heapify(array, largest, heapSize);
		}
	}

}
