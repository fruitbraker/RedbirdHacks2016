import requests
import json
import numpy as np

auth_key = "ZDcxN2JmYTktNTE0Mi00MmRhLWJmNTYtN2Y5N2Q2NmYwNzliYTgzMDdlOWUtZTM3"
roomId = "ded0abd7-0bb5-3400-8080-f7bd06e6ac3f"

url = "https://api.ciscospark.com/v1/messages"

headers = {'X-Requested-With': 'Python requests', 'Content-type': 'application/json', 'Accept': 'application/json',"Authorization":"Bearer " + auth_key}
payload = {"roomId" : roomId}
r = requests.get(url, headers=headers, params = payload)

d = eval(r.text)

c_nb_avgs = [] # n-back averages
i_nb_avgs = []
c_ct_avgs = [] # color-test averages
i_ct_avgs = []
items = d['items']
items.reverse()
for item in items:
	if "NBack" in item['text']:
		t = item['text']
		c_index = t.index("Correct:") + len("Correct:")
		i_index = t.index("Incorrect:") + len("Incorrect:")
		c_ss = t[c_index:i_index-len("Incorrect:")]
		i_ss = t[i_index:]
		#print "Correct nback:", c_ss.split()
		#print "-------------"
		#print "Incorrect nback:", i_ss.split()
		c_nb_avgs.append(np.mean(map(int, c_ss.split())))
		i_nb_avgs.append(np.mean(map(int, i_ss.split())))
	elif "Color Exam" in item['text']:
		t = item['text']
		c_index = t.index("Correct:") + len("Correct:")
		i_index = t.index("Incorrect:") + len("Incorrect:")
		c_ss = t[c_index:i_index-len("Incorrect:")]
		i_ss = t[i_index:]
		#print "Correct nback:", c_ss.split()
		#print "-------------"
		#print "Incorrect nback:", i_ss.split()
		c_ct_avgs.append(np.mean(map(int, c_ss.split())))
		i_ct_avgs.append(np.mean(map(int, i_ss.split())))
print "Correct n-back averages:", c_nb_avgs
print "Incorrect n-back averages:", i_nb_avgs
print "Correct color-test averages:", c_ct_avgs
print "Incorrect color-test averages:", i_ct_avgs