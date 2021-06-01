import json

with open('file1.json') as restaurantsRatingFile:
    apiCalls = json.load(restaurantsRatingFile)
    count = 0
    totalRating = 0
    for apiCall in apiCalls:
        if 'restaurants' in apiCall:
            restaurantsList = apiCall['restaurants']
            for entry in restaurantsList:
                rating = entry["restaurant"]["user_rating"]["aggregate_rating"]
                totalRating += float(rating)
                count += 1

    print("average rating :", totalRating / count)
