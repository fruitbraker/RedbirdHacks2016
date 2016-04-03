import requests
import json

auth_key = "ZDcxN2JmYTktNTE0Mi00MmRhLWJmNTYtN2Y5N2Q2NmYwNzliYTgzMDdlOWUtZTM3"
sparky_id = "722bb271-d7ca-4bce-a9e3-471e4412fa77"
'''
curl https://api.ciscospark.com/v1/messages -X POST 
-H "Authorization:Bearer ZDcxN2JmYTktNTE0Mi00MmRhLWJmNTYtN2Y5N2Q2NmYwNzliYTgzMDdlOWUtZTM3" 
--data "toPersonId=722bb271-d7ca-4bce-a9e3-471e4412fa77" 
--data "text=Hi%20Sparky"
'''


url = "https://api.ciscospark.com/v1/messages"
headers = {'X-Requested-With': 'Python requests', 'Content-type': 'application/json', 'Accept': 'application/json',"Authorization":"Bearer " + auth_key}
payload = {"toPersonId":sparky_id, "text":"I am the night"}
r = requests.post(url, headers=headers, data=json.dumps(payload))

