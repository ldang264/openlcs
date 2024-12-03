In [1]: s = pd.Series(range(5))

In [2]: s.rolling(window=2).sum()
Out[2]: 
0    NaN
1    1.0
2    3.0
3    5.0
4    7.0
dtype: float64

In [3]: for window in s.rolling(window=2):
   ...:     print(window)
   ...: 
0    0
dtype: int64
0    0
1    1
dtype: int64
1    1
2    2
dtype: int64
2    2
3    3
dtype: int64
3    3
4    4
dtype: int64
