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

In [5]: pd.Series([True, False, np.nan], dtype="object") | True
Out[5]: 
0     True
1     True
2    False
dtype: bool

In [6]: pd.Series([True, False, np.nan], dtype="boolean") | True
Out[6]: 
0    True
1    True
2    True
dtype: boolean
