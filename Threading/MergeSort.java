package threads;

public class MergeSort {

	private int[] input;
	public MergeSort(int[] inputs) {
		input = new int[inputs.length];
		for(int i=0;i<inputs.length;i++){
			input[i] = inputs[i];
		}
	}
	
	public void mergeSort(int[] input, int first, int last){
		while(first<last){
			int mid = (first+last)/2;
			mergeSort(input, first,mid);
			mergeSort(input, mid+1, last);
			merge(input, first, mid, last);
		}
	}
	
	private void merge(int array[], int first, int mid, int last) {
		int midPlus1 = mid+1;
		int[] merged = new int[last - first];
		int i=0, j=0;
//		while()
	}

	public static void main(String[] args) {

	}

}
