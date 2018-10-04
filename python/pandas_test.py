import pandas

data = pandas.read_csv('~/Downloads/trains.csv')
for row in data.iterrows():
    print row[1][0], row[1][1], row[1][2]
