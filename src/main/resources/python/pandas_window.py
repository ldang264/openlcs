In [8]: def weighted_mean(x):
   ...:     arr = np.ones((1, x.shape[1]))
   ...:     arr[:, :2] = (x[:, :2] * x[:, 2]).sum(axis=0) / x[:, 2].sum()
   ...:     return arr
   ...: 

In [9]: df = pd.DataFrame([[1, 2, 0.6], [2, 3, 0.4], [3, 4, 0.2], [4, 5, 0.7]])

In [10]: df.rolling(2, method="table", min_periods=0).apply(weighted_mean, raw=True, engine="numba")  # noqa: E501
Out[10]: 
          0         1    2
0  1.000000  2.000000  1.0
1  1.800000  2.000000  1.0
2  3.333333  2.333333  1.0
3  1.555556  7.000000  1.0

In [11]: df = pd.DataFrame([[1, 2, 0.6], [2, 3, 0.4], [3, 4, 0.2], [4, 5, 0.7]])

In [12]: df.ewm(0.5).mean()
Out[12]: 
          0         1         2
0  1.000000  2.000000  0.600000
1  1.750000  2.750000  0.450000
2  2.615385  3.615385  0.276923
3  3.550000  4.550000  0.562500

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
