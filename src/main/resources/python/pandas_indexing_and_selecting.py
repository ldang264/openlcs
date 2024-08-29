In [231]: df = pd.DataFrame(np.random.randint(n / 2, size=(n, 2)), columns=list('bc'))

In [232]: df.index.name = 'a'

In [233]: df
Out[233]: 
   b  c
a      
0  0  4
1  0  1
2  3  4
3  4  3
4  1  4
5  0  3
6  0  1
7  3  4
8  2  3
9  1  1

In [234]: df.query('a < b and b < c')
Out[234]: 
   b  c
a      
2  3  4

In [226]: n = 10

In [227]: df = pd.DataFrame(np.random.rand(n, 3), columns=list('abc'))

In [228]: df
Out[228]: 
          a         b         c
0  0.438921  0.118680  0.863670
1  0.138138  0.577363  0.686602
2  0.595307  0.564592  0.520630
3  0.913052  0.926075  0.616184
4  0.078718  0.854477  0.898725
5  0.076404  0.523211  0.591538
6  0.792342  0.216974  0.564056
7  0.397890  0.454131  0.915716
8  0.074315  0.437913  0.019794
9  0.559209  0.502065  0.026437

# pure python
In [229]: df[(df['a'] < df['b']) & (df['b'] < df['c'])]
Out[229]: 
          a         b         c
1  0.138138  0.577363  0.686602
4  0.078718  0.854477  0.898725
5  0.076404  0.523211  0.591538
7  0.397890  0.454131  0.915716

# query
In [230]: df.query('(a < b) & (b < c)')
Out[230]: 
          a         b         c
1  0.138138  0.577363  0.686602
4  0.078718  0.854477  0.898725
5  0.076404  0.523211  0.591538
7  0.397890  0.454131  0.915716

In [185]: df = pd.DataFrame({'vals': [1, 2, 3, 4], 'ids': ['a', 'b', 'f', 'n'],
   .....:                    'ids2': ['a', 'n', 'c', 'n']})
   .....: 

In [186]: values = ['a', 'b', 1, 3]

In [187]: df.isin(values)
Out[187]: 
    vals    ids   ids2
0   True   True   True
1  False   True  False
2   True  False  False
3  False  False  False

In [181]: s_mi = pd.Series(np.arange(6),
   .....:                  index=pd.MultiIndex.from_product([[0, 1], ['a', 'b', 'c']]))
   .....: 

In [182]: s_mi
Out[182]: 
0  a    0
   b    1
   c    2
1  a    3
   b    4
   c    5
dtype: int64

In [183]: s_mi.iloc[s_mi.index.isin([(1, 'a'), (2, 'b'), (0, 'c')])]
Out[183]: 
0  c    2
1  a    3
dtype: int64

In [184]: s_mi.iloc[s_mi.index.isin(['a', 'c', 'e'], level=1)]
Out[184]: 
0  a    0
   c    2
1  a    3
   c    5
dtype: int64

In [1]: dates = pd.date_range('1/1/2000', periods=8)

In [2]: df = pd.DataFrame(np.random.randn(8, 4),
   ...:                   index=dates, columns=['A', 'B', 'C', 'D'])
   ...: 

In [3]: df
Out[3]: 
                   A         B         C         D
2000-01-01  0.469112 -0.282863 -1.509059 -1.135632
2000-01-02  1.212112 -0.173215  0.119209 -1.044236
2000-01-03 -0.861849 -2.104569 -0.494929  1.071804
2000-01-04  0.721555 -0.706771 -1.039575  0.271860
2000-01-05 -0.424972  0.567020  0.276232 -1.087401
2000-01-06 -0.673690  0.113648 -1.478427  0.524988
2000-01-07  0.404705  0.577046 -1.715002 -1.039268
2000-01-08 -0.370647 -1.157892 -1.344312  0.844885

In [4]: s = df['A']

In [5]: s[dates[5]]
Out[5]: -0.6736897080883706

In [6]: df
Out[6]: 
                   A         B         C         D
2000-01-01  0.469112 -0.282863 -1.509059 -1.135632
2000-01-02  1.212112 -0.173215  0.119209 -1.044236
2000-01-03 -0.861849 -2.104569 -0.494929  1.071804
2000-01-04  0.721555 -0.706771 -1.039575  0.271860
2000-01-05 -0.424972  0.567020  0.276232 -1.087401
2000-01-06 -0.673690  0.113648 -1.478427  0.524988
2000-01-07  0.404705  0.577046 -1.715002 -1.039268
2000-01-08 -0.370647 -1.157892 -1.344312  0.844885

In [7]: df[['B', 'A']] = df[['A', 'B']]

In [8]: df
Out[8]: 
                   A         B         C         D
2000-01-01 -0.282863  0.469112 -1.509059 -1.135632
2000-01-02 -0.173215  1.212112  0.119209 -1.044236
2000-01-03 -2.104569 -0.861849 -0.494929  1.071804
2000-01-04 -0.706771  0.721555 -1.039575  0.271860
2000-01-05  0.567020 -0.424972  0.276232 -1.087401
2000-01-06  0.113648 -0.673690 -1.478427  0.524988
2000-01-07  0.577046  0.404705 -1.715002 -1.039268
2000-01-08 -1.157892 -0.370647 -1.344312  0.844885

In [9]: df[['A', 'B']]
Out[9]: 
                   A         B
2000-01-01 -0.282863  0.469112
2000-01-02 -0.173215  1.212112
2000-01-03 -2.104569 -0.861849
2000-01-04 -0.706771  0.721555
2000-01-05  0.567020 -0.424972
2000-01-06  0.113648 -0.673690
2000-01-07  0.577046  0.404705
2000-01-08 -1.157892 -0.370647

In [10]: df.loc[:, ['B', 'A']] = df[['A', 'B']]

In [11]: df[['A', 'B']]
Out[11]: 
                   A         B
2000-01-01 -0.282863  0.469112
2000-01-02 -0.173215  1.212112
2000-01-03 -2.104569 -0.861849
2000-01-04 -0.706771  0.721555
2000-01-05  0.567020 -0.424972
2000-01-06  0.113648 -0.673690
2000-01-07  0.577046  0.404705
2000-01-08 -1.157892 -0.370647

In [12]: df.loc[:, ['B', 'A']] = df[['A', 'B']].to_numpy()

In [13]: df[['A', 'B']]
Out[13]: 
                   A         B
2000-01-01  0.469112 -0.282863
2000-01-02  1.212112 -0.173215
2000-01-03 -0.861849 -2.104569
2000-01-04  0.721555 -0.706771
2000-01-05 -0.424972  0.567020
2000-01-06 -0.673690  0.113648
2000-01-07  0.404705  0.577046
2000-01-08 -0.370647 -1.157892

In [17]: sa = pd.Series([1, 2, 3], index=list('abc'))

In [18]: dfa = df.copy()

In [19]: sa.b
Out[19]: 2

In [20]: dfa.A
Out[20]: 
2000-01-01   -0.282863
2000-01-02   -0.173215
2000-01-03   -2.104569
2000-01-04   -0.706771
2000-01-05    0.567020
2000-01-06    0.113648
2000-01-07    0.577046
2000-01-08   -1.157892
Freq: D, Name: A, dtype: float64

In [21]: sa.a = 5

In [22]: sa
Out[22]: 
a    5
b    2
c    3
dtype: int64

In [23]: dfa.A = list(range(len(dfa.index)))  # ok if A already exists

In [24]: dfa
Out[24]: 
            A         B         C         D
2000-01-01  0  0.469112 -1.509059 -1.135632
2000-01-02  1  1.212112  0.119209 -1.044236
2000-01-03  2 -0.861849 -0.494929  1.071804
2000-01-04  3  0.721555 -1.039575  0.271860
2000-01-05  4 -0.424972  0.276232 -1.087401
2000-01-06  5 -0.673690 -1.478427  0.524988
2000-01-07  6  0.404705 -1.715002 -1.039268
2000-01-08  7 -0.370647 -1.344312  0.844885

In [25]: dfa['A'] = list(range(len(dfa.index)))  # use this form to create a new column

In [26]: dfa
Out[26]: 
            A         B         C         D
2000-01-01  0  0.469112 -1.509059 -1.135632
2000-01-02  1  1.212112  0.119209 -1.044236
2000-01-03  2 -0.861849 -0.494929  1.071804
2000-01-04  3  0.721555 -1.039575  0.271860
2000-01-05  4 -0.424972  0.276232 -1.087401
2000-01-06  5 -0.673690 -1.478427  0.524988
2000-01-07  6  0.404705 -1.715002 -1.039268
2000-01-08  7 -0.370647 -1.344312  0.844885

In [107]: dfd = pd.DataFrame({'A': [1, 2, 3],
   .....:                     'B': [4, 5, 6]},
   .....:                    index=list('abc'))
   .....: 

In [108]: dfd
Out[108]: 
   A  B
a  1  4
b  2  5
c  3  6

In [109]: dfd.loc[dfd.index[[0, 2]], 'A']
Out[109]: 
a    1
c    3
Name: A, dtype: int64

In [110]: dfd.iloc[[0, 2], dfd.columns.get_loc('A')]
Out[110]: 
a    1
c    3
Name: A, dtype: int64

In [111]: dfd.iloc[[0, 2], dfd.columns.get_indexer(['A', 'B'])]
Out[111]: 
   A  B
a  1  4
c  3  6

In [112]: s = pd.Series([1, 2, 3])

In [113]: s.reindex([1, 2, 3])
Out[113]: 
1    2.0
2    3.0
3    NaN
dtype: float64

In [116]: s = pd.Series(np.arange(4), index=['a', 'a', 'b', 'c'])

In [117]: labels = ['c', 'd']

In [118]: s.reindex(labels)
---------------------------------------------------------------------------
ValueError                                Traceback (most recent call last)
Cell In[118], line 1
----> 1 s.reindex(labels)

File ~/work/pandas/pandas/pandas/core/series.py:5153, in Series.reindex(self, index, axis, method, copy, level, fill_value, limit, tolerance)
   5136 @doc(
   5137     NDFrame.reindex,  # type: ignore[has-type]
   5138     klass=_shared_doc_kwargs["klass"],
   (...)
   5151     tolerance=None,
   5152 ) -> Series:
-> 5153     return super().reindex(
   5154         index=index,
   5155         method=method,
   5156         copy=copy,
   5157         level=level,
   5158         fill_value=fill_value,
   5159         limit=limit,
   5160         tolerance=tolerance,
   5161     )

File ~/work/pandas/pandas/pandas/core/generic.py:5610, in NDFrame.reindex(self, labels, index, columns, axis, method, copy, level, fill_value, limit, tolerance)
   5607     return self._reindex_multi(axes, copy, fill_value)
   5609 # perform the reindex on the axes
-> 5610 return self._reindex_axes(
   5611     axes, level, limit, tolerance, method, fill_value, copy
   5612 ).__finalize__(self, method="reindex")

File ~/work/pandas/pandas/pandas/core/generic.py:5633, in NDFrame._reindex_axes(self, axes, level, limit, tolerance, method, fill_value, copy)
   5630     continue
   5632 ax = self._get_axis(a)
-> 5633 new_index, indexer = ax.reindex(
   5634     labels, level=level, limit=limit, tolerance=tolerance, method=method
   5635 )
   5637 axis = self._get_axis_number(a)
   5638 obj = obj._reindex_with_indexers(
   5639     {axis: [new_index, indexer]},
   5640     fill_value=fill_value,
   5641     copy=copy,
   5642     allow_dups=False,
   5643 )

File ~/work/pandas/pandas/pandas/core/indexes/base.py:4429, in Index.reindex(self, target, method, level, limit, tolerance)
   4426     raise ValueError("cannot handle a non-unique multi-index!")
   4427 elif not self.is_unique:
   4428     # GH#42568
-> 4429     raise ValueError("cannot reindex on an axis with duplicate labels")
   4430 else:
   4431     indexer, _ = self.get_indexer_non_unique(target)

ValueError: cannot reindex on an axis with duplicate labels

In [122]: s = pd.Series([0, 1, 2, 3, 4, 5])

# When no arguments are passed, returns 1 row.
In [123]: s.sample()
Out[123]: 
4    4
dtype: int64

# One may specify either a number of rows:
In [124]: s.sample(n=3)
Out[124]: 
0    0
4    4
1    1
dtype: int64

# Or a fraction of the rows:
In [125]: s.sample(frac=0.5)
Out[125]: 
5    5
3    3
1    1
dtype: int64

In [126]: s = pd.Series([0, 1, 2, 3, 4, 5])

# Without replacement (default):
In [127]: s.sample(n=6, replace=False)
Out[127]: 
0    0
1    1
5    5
3    3
2    2
4    4
dtype: int64

# With replacement:
In [128]: s.sample(n=6, replace=True)
Out[128]: 
0    0
4    4
3    3
2    2
4    4
4    4
dtype: int64

In [134]: df2 = pd.DataFrame({'col1': [9, 8, 7, 6],
   .....:                     'weight_column': [0.5, 0.4, 0.1, 0]})
   .....: 

In [135]: df2.sample(n=3, weights='weight_column')
Out[135]: 
   col1  weight_column
1     8            0.4
0     9            0.5
2     7            0.1

In [158]: s = pd.Series(range(-3, 4))

In [159]: s
Out[159]: 
0   -3
1   -2
2   -1
3    0
4    1
5    2
6    3
dtype: int64

In [160]: s[s > 0]
Out[160]: 
4    1
5    2
6    3
dtype: int64

In [161]: s[(s < -1) | (s > 0.5)]
Out[161]: 
0   -3
1   -2
4    1
5    2
6    3
dtype: int64

In [162]: s[~(s < 0)]
Out[162]: 
3    0
4    1
5    2
6    3
dtype: int64

In [158]: s = pd.Series(range(-3, 4))

In [159]: s
Out[159]: 
0   -3
1   -2
2   -1
3    0
4    1
5    2
6    3
dtype: int64

In [160]: s[s > 0]
Out[160]: 
4    1
5    2
6    3
dtype: int64

In [161]: s[(s < -1) | (s > 0.5)]
Out[161]: 
0   -3
1   -2
4    1
5    2
6    3
dtype: int64

In [162]: s[~(s < 0)]
Out[162]: 
3    0
4    1
5    2
6    3
dtype: int64

In [164]: df2 = pd.DataFrame({'a': ['one', 'one', 'two', 'three', 'two', 'one', 'six'],
   .....:                     'b': ['x', 'y', 'y', 'x', 'y', 'x', 'x'],
   .....:                     'c': np.random.randn(7)})
   .....: 

# only want 'two' or 'three'
In [165]: criterion = df2['a'].map(lambda x: x.startswith('t'))

In [166]: df2[criterion]
Out[166]: 
       a  b         c
2    two  y  0.041290
3  three  x  0.361719
4    two  y -0.238075

# equivalent but slower
In [167]: df2[[x.startswith('t') for x in df2['a']]]
Out[167]: 
       a  b         c
2    two  y  0.041290
3  three  x  0.361719
4    two  y -0.238075

# Multiple criteria
In [168]: df2[criterion & (df2['b'] == 'x')]
Out[168]: 
       a  b         c
3  three  x  0.361719

In [170]: df = pd.DataFrame([[1, 2], [3, 4], [5, 6]],
   .....:                   index=list('abc'),
   .....:                   columns=['A', 'B'])
   .....: 

In [171]: s = (df['A'] > 2)

In [172]: s
Out[172]: 
a    False
b     True
c     True
Name: A, dtype: bool

In [173]: df.loc[s, 'B']
Out[173]: 
b    4
c    6
Name: B, dtype: int64

In [174]: df.iloc[s.values, 1]
Out[174]: 
b    4
c    6
Name: B, dtype: int64

In [175]: s = pd.Series(np.arange(5), index=np.arange(5)[::-1], dtype='int64')

In [176]: s
Out[176]: 
4    0
3    1
2    2
1    3
0    4
dtype: int64

In [177]: s.isin([2, 4, 6])
Out[177]: 
4    False
3    False
2     True
1    False
0     True
dtype: bool

In [178]: s[s.isin([2, 4, 6])]
Out[178]: 
2    2
0    4
dtype: int64
