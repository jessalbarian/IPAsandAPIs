#!/usr/bin/env python

from multiprocessing.dummy import Pool as ThreadPool

#pool = ThreadPool(2)

import json
import urllib
import requests

apiDomain = "http://apis.mondorobot.com/beers?"

request = requests.get(apiDomain)
jsonStuff = json.loads(request.text)
imageUrls = []
for beer in jsonStuff["beers"]:
	#imageUrls.append(beer["label_image"]["original"])
	print beer["label_image"]["original"]
'''
	imageURL = beer["label_image"]["original"]
	substring = imageURL[imageURL.rfind("/"):]
	imageName = substring[substring.find("_")+1:].lower().replace("-","_")
	print imageName
	urllib.URLopener().retrieve(imageURL, imageName)
'''
'''
def getBeerImage(beer):
	imageURL = beer["label_image"]["original"] 
        substring = imageURL[imageURL.rfind("/"):]
        imageName = substring[substring.find("_")+1:].lower().replace("-","_")
        print imageName
        urllib.URLopener().retrieve(imageURL, imageName)

pool.map(getBeerImage, jsonStuff["beers"])
pool.close()
pool.join()
'''
