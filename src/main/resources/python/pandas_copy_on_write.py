In [1]: df = pd.DataFrame({"foo": [1, 2, 3], "bar": [4, 5, 6]})

In [2]: subset = df["foo"]

In [3]: subset.iloc[0] = 100

In [4]: df
Out[4]: 
   foo  bar
0  100    4
1    2    5
2    3    6

In [5]: pd.options.mode.copy_on_write = True

In [6]: df = pd.DataFrame({"foo": [1, 2, 3], "bar": [4, 5, 6]})

In [7]: subset = df["foo"]

In [8]: subset.iloc[0] = 100

In [9]: df
Out[9]: 
   foo  bar
0    1    4
1    2    5
2    3    6
