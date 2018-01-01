import os
import re
import sys
import glob
import nltk
import PyPDF2
import docx2txt
import more_itertools as mit
import matplotlib.pyplot as plt
from math import log10
from collections import Counter
from operator import itemgetter
from wordcloud import WordCloud
from nltk.corpus import stopwords





# FUNCTION

# END OF FUNC


################################################ FUNCTIONS ###############################################################
# FUNCTION
def getFileList(path):
	FileList = glob.glob(path)
	return FileList
# END OF FUNC	

# FUNCTION
def printList(List):
	for element in List:
		print("\n\nElement: \n\n",element)
		#print("Text: \n\n",getText(fileName))
	print("\n\n")
# END OF FUNC

# FUNCTION
def getText(fileName):
	data=[]
	with open(fileName,'r') as f:
		for line in f:
			data.append(line)
	return ''.join(data).lower()
# END OF FUNC

# FUNCTION
def getPDF(fileName):
	pdfData=""
	FileObject = open(fileName, 'rb')
	Reader = PyPDF2.PdfFileReader(FileObject)
	Pages = Reader.numPages
	for page in range(Pages):
		PageObject = Reader.getPage(page)
		pdfData += PageObject.extractText()
	return pdfData.lower()
# END OF FUNC

# FUNCTION 
def getWord(fileName):
	return docx2txt.process(fileName).lower()
# END OF FUNC

# FUNCTION
def getDictTable(words):
	wordfreq = {}
	for word in words.replace(',', ' ').split():
		wordfreq[word] = wordfreq.setdefault(word, 0) + 1
	return wordfreq
# END OF FUNC

# FUNCTION
def getSortedDict(wordDict):
	return sorted(wordDict.items(), key=lambda x: x[1], reverse=True)
#	return OrderedDict(sorted(wordDict.items(), key=lambda x: x[1], reverse=True)[:topBound])
#~~ NOTE : 0 for alphabetically A->Z reverse=False, 1 for ascending number 100->1 reverse=True
# END OF FUNC

# FUNCTION
def addList(listOfDict,fileName):
	if ".txt" in fileName:
		listOfDict.append(getSortedDict(getDictTable((getText(fileName)))))
	elif ".docx" in fileName:
		listOfDict.append(getSortedDict(getDictTable((getWord(fileName)))))
	elif ".pdf" in fileName:
		listOfDict.append(getSortedDict(getDictTable((getPDF(fileName)))))
	else:
		print("\nThis is not my file type...\n")
	return listOfDict
# END OF FUNC

# FUNCTION
def randomColor(word=None, font_size=None, position=None, orientation=None, font_path=None, random_state=None):
    h = int(360.0 * float(random_state.randint(60, 250)) / 255.0)
    s = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    l = int(100.0 * float(random_state.randint(60, 250)) / 255.0)
    return "hsl({}, {}%, {}%)".format(h, s, l)
# END OF FUNC

# FUNCTION
def createCloud(cloudText,path):
	wordcloud = WordCloud(background_color = 'white',width = 1200,height = 1000,
				color_func = randomColor).generate(cloudText)
	f = plt.figure()
	plt.imshow(wordcloud, interpolation="bilinear")
	plt.axis("off")
	plt.show()
	f.savefig(path, bbox_inches='tight')
# END OF FUNC

# FUNCTION
def createCloudText(wordList):
	lineData = []
	for x in range(50):
		lineData.append(mit.nth(wordList, x))
		lineData.append("\n")
	return ''.join(str(lineData))
# END OF FUNC

# FUNCTION
def getDictElements(myList,index,bound):
	return myList[index][:bound]
	#print(myList[index][:bound])
# END OF FUNC

# FUNCTION
def printTopElements(myList,bound):
	elementIndex=0
	for element in myList:
		print("\nElement : ",elementIndex+1, "- Top ",bound," Elements")
		print(element[:2])
		if elementIndex >= bound-1 :
		    break
		elementIndex+=1
# END OF FUNC

# FUNCTION
def termFrequency(textData):
    listOfDict = []
    frequencyList = []    
    tfList = []
    for text in textData:
        listOfDict.append(Counter(text.split()))
    for dictionary in listOfDict:
        frequencyList.append(list(dictionary.items()))
    for newWords in frequencyList:
        tfList.append(sorted(newWords, key = lambda tup: tup[1])[::-1])
    return tfList
# END OF FUNC

# FUNCTION
def inverseDocumentFrequency(textData):
    tfList = termFrequency(textData)
    newIdfList = []
    idfList = []
    for tfElement in tfList:
        someList = []
        for vocab in tfElement:
            tupleElement = list(vocab)
            freq = 0
            for text in textData:
                if tupleElement[0] in text:
                    freq += 1
            tupleElement[1] *= log10(float( len(textData) )/ float(freq) )
            someList.append(tuple(tupleElement))
        newIdfList.append(someList)
    for newWords in newIdfList:
        idfList.append(sorted(newWords, key = lambda tup: tup[1])[::-1])
    return idfList    
# END OF FUNC

# FUNCTION
def printFile(filename, tfList):
    length= len(tfList)
    if os.path.exists(filename):
        os.remove(filename)
    with open(filename, 'a') as file:
        limit = 50
        if(length < 50):
            limit = length
        for i in range(limit):
            tupleElement = tfList[i]
            text = str(tupleElement[0]) + ";" + str(tupleElement[1])
            if(not tupleElement[0] == tfList[length-1][0]):
                text += "\n"
            file.write(text)
# END OF FUNC


# FUNCTION
def printLen(tfList,idfList,bound):
	r=0
	for r in range(len(tfList)):
		print("\nTF LIST ",r,"\n")
		printTopElements(tfList[r],bound)
 
	for r in range(len(idfList)):
		print("\nTF-IDF LIST ",r,"\n")
		printTopElements(idfList[r],bound)
# END OF FUNC

################################################ END OF FUNCTIONS ##########################################################


###################################################   MAIN    ##############################################################

topBound=50
stop_words = set(stopwords.words('english'))
path="input/*.*"
fileList= getFileList(path)
rawText=[]
text =""
index=0
print("\n")
for fileName in fileList:
    if ".txt" in fileName:
        print("Filename: ", fileName)
        text = getText(fileName)
        text = re.sub(r'[^\w\s]','',text)
    elif ".docx" in fileName:
        print("Filename: ", fileName)
        text = getWord(fileName)
        text = re.sub(r'[^\w\s]','',text)
    elif ".pdf" in fileName:
        print("Filename: ", fileName)
        text = getPDF(fileName)
        text = re.sub(r'[^\w\s]','',text)
    else:
        print("\n",fileName," is not my file type...") 
    rawText.insert(index,text)

filtered_sentence = []    
for w in rawText:
    if w not in stop_words:
        filtered_sentence.append(w)

print("\nTF LIST \n")
printTopElements(termFrequency(filtered_sentence)[0],topBound)
print("\nTF-IDF LIST \n")
printTopElements(inverseDocumentFrequency(filtered_sentence)[0],topBound)
printFile("output/tf_list.csv",termFrequency(filtered_sentence)[0])
printFile("output/tfidf_list.csv",inverseDocumentFrequency(filtered_sentence)[0])
topTF50 = termFrequency(filtered_sentence)[0][:50]
topIDF50 = inverseDocumentFrequency(filtered_sentence)[0][:50]
createCloud(createCloudText(topTF50),"output/tf_wordCloud.pdf")
createCloud(createCloudText(topIDF50),"output/tfidf_wordCloud.pdf")





###################################################   MAIN    ##############################################################

