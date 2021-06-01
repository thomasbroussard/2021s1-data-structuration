import json

with open('fr.json') as countriesFile:
    countries = json.load(countriesFile)
    total: int = 0
    for country in countries:
        populationAsString: str = country['population']
        population: int = 0
        if populationAsString != '':
            population = int(populationAsString)
        total += population
    print('total population :  ', total)
    print('average population per city:  ', total/len(countries))

