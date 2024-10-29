In [21]: pd.concat([df[["A"]], df[["B", "C"]]], axis=1).dtypes
Out[21]: 
A     Int64
B     int64
C    object
dtype: object

In [22]: df["A"].astype(float)
Out[22]: 
0    1.0
1    2.0
2    NaN
Name: A, dtype: float64

In [23]: df.sum(numeric_only=True)
Out[23]: 
A    3
B    5
dtype: Int64

In [24]: df.sum()
Out[24]: 
A      3
B      5
C    aab
dtype: object

In [25]: df.groupby("B").A.sum()
Out[25]: 
B
1    3
3    0
Name: A, dtype: Int64

In [12]: s = pd.Series([1, 2, None], dtype="Int64")

# arithmetic
In [13]: s + 1
Out[13]: 
0       2
1       3
2    <NA>
dtype: Int64

# comparison
In [14]: s == 1
Out[14]: 
0     True
1    False
2     <NA>
dtype: boolean

# slicing operation
In [15]: s.iloc[1:3]
Out[15]: 
1       2
2    <NA>
dtype: Int64

# operate with other dtypes
In [16]: s + s.iloc[1:3].astype("Int8")
Out[16]: 
0    <NA>
1       4
2    <NA>
dtype: Int64

# coerce when needed
In [17]: s + 0.01
Out[17]: 
0    1.01
1    2.01
2    <NA>
dtype: Float64In [1]: arr = pd.array([1, 2, None], dtype=pd.Int64Dtype())

In [2]: arr
Out[2]: 
<IntegerArray>
[1, 2, <NA>]
Length: 3, dtype: Int64

In [3]: pd.array([1, 2, np.nan], dtype="Int64")
Out[3]: 
<IntegerArray>
[1, 2, <NA>]
Length: 3, dtype: Int64
