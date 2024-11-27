In [3]: np.random.seed(123456)

In [4]: ts = pd.Series(np.random.randn(1000), index=pd.date_range("1/1/2000", periods=1000))

In [5]: ts = ts.cumsum()

In [6]: ts.plot();

In [7]: df = pd.DataFrame(np.random.randn(1000, 4), index=ts.index, columns=list("ABCD"))

In [8]: df = df.cumsum()

In [9]: plt.figure();

In [10]: df.plot();

In [25]: df4 = pd.DataFrame(
   ....:     {
   ....:         "a": np.random.randn(1000) + 1,
   ....:         "b": np.random.randn(1000),
   ....:         "c": np.random.randn(1000) - 1,
   ....:     },
   ....:     columns=["a", "b", "c"],
   ....: )
   ....: 

In [26]: plt.figure();

In [27]: df4.plot.hist(alpha=0.5);

In [28]: plt.figure();

In [29]: df4.plot.hist(stacked=True, bins=20);

In [30]: plt.figure();

In [31]: df4["a"].plot.hist(orientation="horizontal", cumulative=True);
