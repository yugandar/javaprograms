
public class mergeSort {
	public static void printA(Integer[] B){
		for(int i=0;i<B.length;i++){
			System.out.println(B[i]);
		}
	}
	public static Integer[] mergeSort1(Integer[] numb){
		if(numb.length<=1){
			return numb;//1 number left or nothing
		}else {
			int nMidpoint=numb.length/2; //cal the mid number
			Integer []left=new Integer[nMidpoint];
			Integer []right;
			if(numb.length%2==0){
				right=new Integer[nMidpoint];
			}else{
				right=new Integer[nMidpoint+1];
			}
			Integer [] finalNumb=new Integer[numb.length];

			for(int i=0;i<nMidpoint;i++){
				left[i]=numb[i];
			}
			int m=0;
			for(int i=nMidpoint;i<numb.length;i++){
				right[m]=numb[i];
				m++;
			}

			left=mergeSort1(left);
			right=mergeSort1(right);
			finalNumb=merge(left,right);
			return finalNumb;
		}
	}

	public static Integer[] merge(Integer[] left,Integer[] right){
		int finalLength=left.length+right.length;
		Integer[] result=new Integer[finalLength];
		int L=0;
		int R=0;
		int res=0;
		while(L<left.length||R<right.length){
			if(L<left.length&&R<right.length){
				if(left[L]<right[R]){
					result[res]=left[L];
					res++;
					L++;
				}else{
					result[res]=right[R];
					res++;
					R++;
				}
			}else if(L<left.length){
				result[res]=left[L];
				res++;
				L++;
			}else if(R<right.length){
				result[res]=right[R];
				res++;
				R++;
			}
		}
		return result;
		}

}
