#include <stdio.h>

int main(void){
	int i,number[10],count=0,temp,num,j;
	scanf("%d",&num);
	for(i=0; ;i++){
		number[i] = num%10;
		num/=10;
		count++;
		if(num == 0)
			break;
	}
	
	for(i=0; i<count; i++){
		for(j=i; j<count; j++){
			if(number[i]<number[j]){
				temp = number[i];
				number[i] = number[j];
				number[j] = temp;
			}
		}
	}
	for(i=0; i<count; i++){
		printf("%d",number[i]);
	}
	
}