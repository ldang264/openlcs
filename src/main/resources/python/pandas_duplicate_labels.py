In [29]: s1 = pd.Series(0, index=["a", "b"]).set_flags(allows_duplicate_labels=False)

In [30]: s1
Out[30]: 
a    0
b    0
dtype: int64

In [31]: s1.head().rename({"a": "b"})
---------------------------------------------------------------------------
DuplicateLabelError                       Traceback (most recent call last)
Cell In[31], line 1
----> 1 s1.head().rename({"a": "b"})

File ~/work/pandas/pandas/pandas/core/series.py:5090, in Series.rename(self, index, axis, copy, inplace, level, errors)
   5083     axis = self._get_axis_number(axis)
   5085 if callable(index) or is_dict_like(index):
   5086     # error: Argument 1 to "_rename" of "NDFrame" has incompatible
   5087     # type "Union[Union[Mapping[Any, Hashable], Callable[[Any],
   5088     # Hashable]], Hashable, None]"; expected "Union[Mapping[Any,
   5089     # Hashable], Callable[[Any], Hashable], None]"
-> 5090     return super()._rename(
   5091         index,  # type: ignore[arg-type]
   5092         copy=copy,
   5093         inplace=inplace,
   5094         level=level,
   5095         errors=errors,
   5096     )
   5097 else:
   5098     return self._set_name(index, inplace=inplace, deep=copy)

File ~/work/pandas/pandas/pandas/core/generic.py:1140, in NDFrame._rename(self, mapper, index, columns, axis, copy, inplace, level, errors)
   1138     return None
   1139 else:
-> 1140     return result.__finalize__(self, method="rename")

File ~/work/pandas/pandas/pandas/core/generic.py:6262, in NDFrame.__finalize__(self, other, method, **kwargs)
   6255 if other.attrs:
   6256     # We want attrs propagation to have minimal performance
   6257     # impact if attrs are not used; i.e. attrs is an empty dict.
   6258     # One could make the deepcopy unconditionally, but a deepcopy
   6259     # of an empty dict is 50x more expensive than the empty check.
   6260     self.attrs = deepcopy(other.attrs)
-> 6262 self.flags.allows_duplicate_labels = other.flags.allows_duplicate_labels
   6263 # For subclasses using _metadata.
   6264 for name in set(self._metadata) & set(other._metadata):

File ~/work/pandas/pandas/pandas/core/flags.py:96, in Flags.allows_duplicate_labels(self, value)
     94 if not value:
     95     for ax in obj.axes:
---> 96         ax._maybe_check_unique()
     98 self._allows_duplicate_labels = value

File ~/work/pandas/pandas/pandas/core/indexes/base.py:715, in Index._maybe_check_unique(self)
    712 duplicates = self._format_duplicate_message()
    713 msg += f"\n{duplicates}"
--> 715 raise DuplicateLabelError(msg)

DuplicateLabelError: Index has duplicates.
      positions
label          
b        [0, 1]

In [9]: df2 = pd.DataFrame({"A": [0, 1, 2]}, index=["a", "a", "b"])

In [10]: df2
Out[10]: 
   A
a  0
a  1
b  2

In [11]: df2.loc["b", "A"]  # a scalar
Out[11]: 2

In [12]: df2.loc["a", "A"]  # a Series
Out[12]: 
a    0
a    1
Name: A, dtype: int64

In [1]: import pandas as pd

In [2]: import numpy as np

In [3]: s1 = pd.Series([0, 1, 2], index=["a", "b", "b"])

In [4]: s1.reindex(["a", "b", "c"])
---------------------------------------------------------------------------
ValueError                                Traceback (most recent call last)
Cell In[4], line 1
----> 1 s1.reindex(["a", "b", "c"])

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

In [5]: df1 = pd.DataFrame([[0, 1, 2], [3, 4, 5]], columns=["A", "A", "B"])

In [6]: df1
Out[6]: 
   A  A  B
0  0  1  2
1  3  4  5

