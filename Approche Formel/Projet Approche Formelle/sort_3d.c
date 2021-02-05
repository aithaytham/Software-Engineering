
void display(int *t, int l)
{
  int i; 
  printf_va_1("{ ");
  i = 0;
  while (1) {
    /*@ assert rte: signed_overflow: -2147483648 ≤ l - 1; */
    if (! (i < l - 1)) {
      break;
    }
    {
      /*@ assert rte: mem_access: \valid_read(t + i); */
      printf_va_2("%d, ",*(t + i));
    }
    /*@ assert rte: signed_overflow: i + 1 ≤ 2147483647; */
    i ++;
  }
  /*@ assert rte: mem_access: \valid_read(t + i); */
  printf_va_3("%d}\n",*(t + i));
  return;
}


void swap(int *t, int n, int i, int j)
{
  int tmp;
  /*@ assert rte: mem_access: \valid_read(t + i); */
  tmp = *(t + i);
  /*@ assert rte: mem_access: \valid(t + i); */
  /*@ assert rte: mem_access: \valid_read(t + j); */
  *(t + i) = *(t + j);
  /*@ assert rte: mem_access: \valid(t + j); */
  *(t + j) = tmp;
  return;
}


void sort(int *t, int n)
{
  int i;
  int ok = 1;
  i = 0;
  while (i < n) {
    {
      /*@ assert rte: mem_access: \valid_read(t + i); */
      if (*(t + i) != 0) {
        /*@ assert rte: mem_access: \valid_read(t + i); */
        if (*(t + i) != 1) {
          /*@ assert rte: mem_access: \valid_read(t + i); */
          if (*(t + i) != 2) {
            ok = 0;
          }
        }
      }
    }
    /*@ assert rte: signed_overflow: i + 1 ≤ 2147483647; */
    i ++;
  }
  if (ok == 0) {
    i = 0;
    while (i < n) {
      {
        /*@ assert rte: mem_access: \valid(t + i); */
        *(t + i) = 0;
      }
      /*@ assert rte: signed_overflow: i + 1 ≤ 2147483647; */
      i ++;
    }
  }
  else {
    int i_0;
    int zeros = 0;
    int ones = 0;
    i_0 = 0;
    while (i_0 < n) {
      {
        /*@ assert rte: mem_access: \valid_read(t + i_0); */
        if (*(t + i_0) == 0) {
          swap(t,n,zeros,i_0);
          /*@ assert rte: signed_overflow: zeros + 1 ≤ 2147483647; */
          zeros ++;
          swap(t,n,i_0,ones);
          /*@ assert rte: signed_overflow: ones + 1 ≤ 2147483647; */
          ones ++;
        }
        else {
          /*@ assert rte: mem_access: \valid_read(t + i_0); */
          if (*(t + i_0) == 1) {
            swap(t,n,ones,i_0);
            /*@ assert rte: signed_overflow: ones + 1 ≤ 2147483647; */
            ones ++;
          }
        }
      }
      /*@ assert rte: signed_overflow: i_0 + 1 ≤ 2147483647; */
      i_0 ++;
    }
  }
  return;
}

int main(void)
{
  int __retres;
  int t[10] = {1, 1, 2, 2, 1, 1, 2, 1, 1, 0};
  sort(t,10);
  display(t,10);
  __retres = 0;
  return __retres;
}