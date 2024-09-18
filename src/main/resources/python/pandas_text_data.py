In [1]: pd.Series(["a", "b", "c"])
Out[1]: 
0    a
1    b
2    c
dtype: object

In [2]: pd.Series(["a", "b", "c"], dtype="string")
Out[2]: 
0    a
1    b
2    c
dtype: string

In [3]: pd.Series(["a", "b", "c"], dtype=pd.StringDtype())
Out[3]: 
0    a
1    b
2    c
dtype: string

In [4]: s = pd.Series(["a", "b", "c"])

In [5]: s
Out[5]: 
0    a
1    b
2    c
dtype: object

In [6]: s.astype("string")
Out[6]: 
0    a
1    b
2    c
dtype: string

In [7]: s = pd.Series(["a", 2, np.nan], dtype="string")

In [8]: s
Out[8]: 
0       a
1       2
2    <NA>
dtype: string

In [9]: type(s[1])
Out[9]: str
