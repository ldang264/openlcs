In [12]: arrays = [
   ....:     np.array(["bar", "bar", "baz", "baz", "foo", "foo", "qux", "qux"]),
   ....:     np.array(["one", "two", "one", "two", "one", "two", "one", "two"]),
   ....: ]
   ....: 

In [13]: s = pd.Series(np.random.randn(8), index=arrays)

In [14]: s
Out[14]: 
bar  one   -0.861849
     two   -2.104569
baz  one   -0.494929
     two    1.071804
foo  one    0.721555
     two   -0.706771
qux  one   -1.039575
     two    0.271860
dtype: float64

In [15]: df = pd.DataFrame(np.random.randn(8, 4), index=arrays)

In [16]: df
Out[16]: 
                0         1         2         3
bar one -0.424972  0.567020  0.276232 -1.087401
    two -0.673690  0.113648 -1.478427  0.524988
baz one  0.404705  0.577046 -1.715002 -1.039268
    two -0.370647 -1.157892 -1.344312  0.844885
foo one  1.075770 -0.109050  1.643563 -1.469388
    two  0.357021 -0.674600 -1.776904 -0.968914
qux one -1.294524  0.413738  0.276662 -0.472035
    two -0.013960 -0.362543 -0.006154 -0.923061

In [1]: arrays = [
   ...:     ["bar", "bar", "baz", "baz", "foo", "foo", "qux", "qux"],
   ...:     ["one", "two", "one", "two", "one", "two", "one", "two"],
   ...: ]
   ...: 

In [2]: tuples = list(zip(*arrays))

In [3]: tuples
Out[3]: 
[('bar', 'one'),
 ('bar', 'two'),
 ('baz', 'one'),
 ('baz', 'two'),
 ('foo', 'one'),
 ('foo', 'two'),
 ('qux', 'one'),
 ('qux', 'two')]

In [4]: index = pd.MultiIndex.from_tuples(tuples, names=["first", "second"])

In [5]: index
Out[5]: 
MultiIndex([('bar', 'one'),
            ('bar', 'two'),
            ('baz', 'one'),
            ('baz', 'two'),
            ('foo', 'one'),
            ('foo', 'two'),
            ('qux', 'one'),
            ('qux', 'two')],
           names=['first', 'second'])

In [6]: s = pd.Series(np.random.randn(8), index=index)

In [7]: s
Out[7]: 
first  second
bar    one       0.469112
       two      -0.282863
baz    one      -1.509059
       two      -1.135632
foo    one       1.212112
       two      -0.173215
qux    one       0.119209
       two      -1.044236
dtype: float64
