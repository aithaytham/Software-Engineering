/*@ requires \valid(t) && \valid(l);
*/
void display(int *t, int l);

/*@ requires \valid(i) && \valid(j) && \valid(t);
  @ ensures A: *t[i] == \old(*t[j]) ;
  @ ensures B: *t[j] == \old(*t[i]) ;
  @ assigns *t[i],*t[j] ; 
  @*/
void swap(int *t, int n, int i, int j);

/*@ requires \valid(t) && \valid(n);
*/
void sort(int *t, int n);