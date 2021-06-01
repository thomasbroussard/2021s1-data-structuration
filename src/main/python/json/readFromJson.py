import json

with open('fr.json') as countriesFile:
    countries = json.load(countriesFile)
    data = [country['admin_name'] for country in countries]

print(data)
