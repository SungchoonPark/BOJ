#include <stdio.h>

int main(void){
	int num[100],max=0,maxIndex;
	for(int i=0; i<9; i++){
		scanf("%d",&num[i]);
	}
	for(int i=0; i<9; i++){
		if(max < num[i]){
			max = num[i];
			maxIndex = i+1;
		}
	}
	printf("%d\n",max);
	printf("%d",maxIndex);
}