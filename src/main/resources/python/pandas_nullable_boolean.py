In [1]: s = pd.Series([1, 2, 3])

In [2]: mask = pd.array([True, False, pd.NA], dtype="boolean")

In [3]: s[mask]
Out[3]: 
0    1
dtype: int64

In [4]: s[mask.fillna(True)]
Out[4]: 
0    1
2    3
dtype: int64
