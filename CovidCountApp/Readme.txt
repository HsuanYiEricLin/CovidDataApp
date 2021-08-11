This is the the coding Assignment given as the recruitment coding challenge

Instructions on how to run CovidCountApp.jar:
1) navigate to the directory with the jar file
2) java -jar CovidCountApp.jar
-> note: this is the default condition when given no parameters
-> 2 csv files should show up with data from https://covid19api.com/
-> data should be grouped and sorted by Date

3) java -jar CovidCountApp.jar para1 para2 para3 para4 para5 para6

->users can choose to give how many parameters.
->however, only up to maximum of 4 supported countries (parameters will be checked up to certain degree)
ie1) java -jar CovidCountApp.jar canada south-africa japan
ie2) java -jar CovidCountApp.jar canada south-africa japan 2021-08-02 2021-08-10

how the app will obtain the specific time range is using the format
\d{4}-\d{2}-\d{2} or XXXX-XX-XX and the rest of the time will assumed as T00:00:00Z
-> note: there might be some random data errors such as weird numbers for active and recovered.
-> please refer to sample screenshot as those are the json data i GET from the api site.