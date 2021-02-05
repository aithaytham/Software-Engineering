import os
import numpy as np
import matplotlib.pyplot as plt
from pathlib import Path
from scipy.cluster.hierarchy import dendrogram, linkage, fcluster
from scipy.cluster.hierarchy import cophenet, inconsistent, maxRstat
from scipy.spatial.distance import pdist

# generating random data if needed,

# otherwise provide X(n,m) with n samples and m features


np.random.seed(8888)  # pour répéter le même jeu de données

a = np.random.multivariate_normal([10, 0], [[3, 1], [1, 4]], size=[100,])

b = np.random.multivariate_normal([0, 20], [[3, 1], [1, 4]], size=[50,])

X = np.concatenate((a, b),)

plt.scatter(X[:,0], X[:,1])

plt.title('My data distribution')

plt.show()

# generate the linkage matrix
# alternative linkage methods: 'single', 'complete', 'average' ,
#   'euclidean' (default), 'cityblock' aka Manhattan, 'hamming', 'cosine'

Z = linkage(X, 'complete', 'cityblock', optimal_ordering=True)

# Check the Cophenetic Correlation Coeficcient
# the closer to 1 the better

c, coph_dists = cophenet(Z, pdist(X))
print('Cophenetic Correlation:%1.2f' % c)

# calculate and view the full dendrogram
# X axis is for the labels, Y axis is for the distances
# the vertical lines indicate the distance at which the labels were merged

plt.figure(figsize=(25, 10))
plt.title('Hierachical Clustering Dendrogram (full)')
plt.xlabel('sample clusters')
plt.ylabel('distance')

dendrogram(Z, leaf_rotation=90., leaf_font_size=8.,)

plt.show()

# truncate the dendrogram for better visibility
# with only the last p=12 merged clusters,
# and labeled with cluster's inconsistency coefficient

R = inconsistent(Z)  # Question 4:   1/2 param: id cluster fusionné; 3param: distance point; 4param nombre de points

# truncate the dendrogram for better visibility
plt.title('Hierarchical Clustering Dendrogram (truncated)')
plt.xlabel('sample index')
plt.ylabel('distance')
dendrogram(
    Z,
    truncate_mode='lastp',  # to explain
    p=12,  # to explain
    show_leaf_counts=False,  # otherwise numbers in brackets are counts
    leaf_rotation=90.,
    leaf_font_size=12.,
    show_contracted=True,  # to get a distribution impression in truncated branches
    )
plt.show()

max_d = 2
clusters = fcluster(Z, max_d, criterion='distance')

plt.figure(figsize=(10, 8))
plt.scatter(X[:, 0], X[:, 1], c=clusters, cmap='prism')
plt.show()

k=5
clusters=fcluster(Z, k, criterion='maxclust')

plt.figure(figsize=(10, 8))
plt.scatter(X[:, 0], X[:, 1], c=clusters, cmap='prism')
plt.show()

