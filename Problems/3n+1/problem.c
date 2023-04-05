#include <stdio.h>

int main() {
    int i, j, counter = 1, max_counter = 1, output_var;          //Counter
    scanf("%d %d", &i, &j);     //Input
    output_var = i;

    if (j < i) {
        int tmp = j;
        j = i;
        i = tmp;
    }
    int start;

    while (i < j + 1) {
        start = i;      
        while (start > 1) {
            if (start % 2) {
                start *= 3;
                start++;
            }

            else
                start /= 2;
            counter++;
        }
        if (max_counter < counter)          //Set new Pseudo-MAX
            max_counter = counter;
        counter = 1;
        i++;        //Raise the numb
    }

    printf("%d %d %d\n", output_var, j, max_counter);
    return 0;
}