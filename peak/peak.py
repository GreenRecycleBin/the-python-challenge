import pickle
import sys

data = pickle.load(open('banner.p'))

for l in data:
    for t in l:
        sys.stdout.write(t[0] * t[1])

    print
