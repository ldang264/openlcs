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

