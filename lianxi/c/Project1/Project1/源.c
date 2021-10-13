#include <stdio.h>
int calculating(int n, int count);

int main(int argc, char const *argv[]) {
	int n = 3;
	int count = 0;
	if (n % 2 == 0) {
		count++;
		if(n==1){
			printf(count);
			return 0;
		}
	else
		calculating(n, count);

	}
	else
		calculating(n, count);
	printf(count);

	return 0;

}
int calculating(int n, int count) {

	while (n == 1) {
		n = (3*n + 1) / 2;
		count++;
	}
	return count;
}